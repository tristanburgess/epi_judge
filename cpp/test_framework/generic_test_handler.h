
#pragma once

#include <iterator>
#include <numeric>
#include <regex>
#include <string>
#include <tuple>
#include <vector>

#include "test_output.h"
#include "test_utils.h"
#include "test_utils_meta.h"
#include "serialization_traits.h"
#include "timed_executor.h"

/**
 * The central class in generic test runner framework.
 * It is responsible for asserting that the function signature matches
 * the one from the test file header and
 * executing tests on the provided function (which includes
 * the deserialization of the provided arguments
 * and the expected value,
 * invocation of the target method with these arguments and
 * comparison of the computed result with the expected value).
 *
 * ParseSignature() and RunTest() throw RuntimeException
 * in case of any error or assertion failure.
 * This exception terminates testing and,
 * consequently, the test program.
 * If tested method throws TestFailure,
 * the current test is marked as failed and the execution goes on.
 * In case of any other exception thrown by the tested method,
 * the test program is terminated.
 */
template <typename Function, typename Comparator>
class GenericTestHandler {
 private:
  using has_default_comparator = std::is_same<Comparator, DefaultComparator>;

  using func_traits = FunctionalTraits<Function>;

  template <size_t I>
  using ith_arg_trait =
      SerializationTraits<typename func_traits::template ith_arg_t<I>>;

  using arg_index_sequence = std::make_index_sequence<
      std::tuple_size<typename func_traits::arg_tuple_t>::value>;

  using expected_value_t = typename SerializationTraits<std::conditional_t<
      has_default_comparator::value, typename func_traits::return_t,
      typename BiPredicateTraits<Comparator>::arg1_t>>::serialization_type;

  static_assert(std::is_same<expected_value_t, void>::value ==
                    std::is_same<typename func_traits::return_t, void>::value,
                "Expected type and return type are either both void or not");

  struct ExpectedIsVoidTag {};
  struct ExpectedIsValueTag {};
  using expected_tag =
      std::conditional_t<std::is_same<expected_value_t, void>::value,
                         ExpectedIsVoidTag, ExpectedIsValueTag>;

 public:
  GenericTestHandler(Function func, Comparator comp,
                     const std::string& func_name,
                     const std::vector<std::string>& param_names)
      : func_(func), comp_(comp), func_name_(func_name), param_names_(param_names) {
    if (func_traits::HasExecutorHook()) {
      param_names_.erase(
          param_names_.begin());  // Remove "executor" parameter
    }
  }

  /**
   * This method ensures that test data header matches with the signature of
   * the tested function.
   *
   * @param signature - test data header
   */
  void ParseSignature(const std::vector<std::string>& signature) {
    using arg_tuple_t = typename func_traits::arg_tuple_t;

    MatchFunctionSignature<expected_value_t, arg_tuple_t>(
        std::cbegin(signature), std::cend(signature));

    if (param_names_.size() != signature.size() - 1) {
      throw std::runtime_error("parameter names count mismatch");
    }
  }

  /**
   * This method is invoked for each row
   * in a test data file (except the header).
   * It deserializes the list of arguments and
   * calls the user function with them.
   *
   * @param timeout_seconds - number of seconds to timeout.
   * @param test_args - serialized arguments.
   * @return true if result generated by the user method
   *    matches with the expected value, false otherwise.
   */
  TestOutput RunTest(const std::chrono::seconds& timeout_seconds,
                     const std::vector<std::string>& test_args) const {
    auto args_begin = std::cbegin(test_args);
    auto args_end = std::cend(test_args) - (ExpectedIsVoid() ? 0 : 1);

    auto args = ParseSerializedArgs<typename func_traits::arg_tuple_t>(
        args_begin, args_end);

    auto metrics = CalculateMetrics(args, arg_index_sequence());

    TimedExecutor executor(timeout_seconds);
    auto timer = ParseExpectedAndInvoke(executor, test_args.back(), args);
    return {timer, std::move(metrics)};
  }

  static constexpr bool ExpectedIsVoid() {
    return std::is_same<expected_tag, ExpectedIsVoidTag>::value;
  }

  const std::string& FuncName() const { return func_name_; }

  const std::vector<std::string>& ParamNames() const { return param_names_; }

  std::vector<std::string> MetricNames() const {
    return MetricNamesImpl(arg_index_sequence());
  }

 private:
  template <size_t... I>
  std::vector<std::string> MetricNamesImpl(
      std::index_sequence<I...> /*unused*/) const {
    return FlattenVector<std::string>(
        {ith_arg_trait<I>::GetMetricNames(param_names_[I])...});
  }

  template <typename ArgTupleT, size_t... I>
  std::vector<int> CalculateMetrics(
      const ArgTupleT& args, std::index_sequence<I...> /*unused*/) const {
    return FlattenVector<int>(
        {ith_arg_trait<I>::GetMetrics(std::get<I>(args))...});
  }

  /**
   * This method parses expected value (if return type is not void),
   * invokes the tested function and compares
   * the computed result with the expected value.
   *
   * The reason to put it in a separate function is that
   * the implementation differs in case the return type is void.
   * The two versions should be put in different functions and
   * the right overload is chosen with a tag dispatching.
   *
   * @param serialized_expected - string representation
   *    of the expected value or unknown string if return type is void.
   * @param args - deserialized function arguments, passed in a tuple.
   * @return tuple, that contains [result of comparison of expected and
   * result, optional<expected>, optional<result>].
   */
  template <typename ArgTuple>
  TestTimer ParseExpectedAndInvoke(TimedExecutor& executor,
                                   const std::string& serialized_expected,
                                   ArgTuple& args) const {
    return ParseExpectedAndInvokeImpl(expected_tag(), executor,
                                      serialized_expected, args);
  }

  /**
   * ParseExpectedAndInvoke version for non-void return type
   */
  template <typename ArgTuple>
  TestTimer ParseExpectedAndInvokeImpl(ExpectedIsValueTag,
                                       TimedExecutor& executor,
                                       const std::string& serialized_expected,
                                       ArgTuple& args) const {
    using expected_value_trait = SerializationTraits<expected_value_t>;
    auto expected = expected_value_trait::Parse(serialized_expected);

    auto result = Invoke(executor, args, arg_index_sequence());

    AssertResultEqual(expected, result);

    return executor.GetTimer();
  }

  /**
   * ParseExpectedAndInvoke version for void return type
   */
  template <typename ArgTuple>
  TestTimer ParseExpectedAndInvokeImpl(ExpectedIsVoidTag,
                                       TimedExecutor& executor,
                                       const std::string& serialized_expected,
                                       ArgTuple& args) const {
    Invoke(executor, args, arg_index_sequence());

    return executor.GetTimer();
  }

  /**
   * Invokes the tested function with the provided set of arguments.
   * @param args - deserialized function arguments, passed in a tuple.
   * @return whatever the tested function returns
   */
  template <typename ArgTuple, std::size_t... I>
  decltype(auto) Invoke(TimedExecutor& executor, ArgTuple& args,
                        std::index_sequence<I...> /*unused*/) const {
    return InvokeWithExecutor(typename func_traits::executor_hook_tag(),
                              func_, executor, std::get<I>(args)...);
  };

  template <typename T, typename U>
  void AssertResultEqual(T& expected, U& result) const {
    bool comparison_result = comp_(expected, result);
    if (!comparison_result) {
      throw TestFailure()
          .WithProperty(PropertyName::EXPECTED, std::move(expected))
          .WithProperty(PropertyName::RESULT, std::move(result));
    }
  };

  Function func_;
  Comparator comp_;
  std::string func_name_;
  std::vector<std::string> param_names_;
};
