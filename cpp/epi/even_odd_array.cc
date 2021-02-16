#include <set>
#include <vector>
#include "generic_test.h"
#include "test_failure.h"
#include "timed_executor.h"
using std::vector;

void EvenOdd(vector<int>* A_ptr) {
  // TODO - you fill in here.
  return;
}

void EvenOddWrapper(TimedExecutor& executor, vector<int> A) {
  std::multiset<int> before(begin(A), end(A));

  executor.Run([&] { EvenOdd(&A); });

  bool in_odd = false;
  for (int a : A) {
    if (a % 2 == 0) {
      if (in_odd) {
        throw TestFailure("Even elements appear in odd part");
      }
    } else {
      in_odd = true;
    }
  }

  std::multiset<int> after(begin(A), end(A));
  if (before != after) {
    throw TestFailure("Elements mismatch");
  }
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"executor", "A"};
  return GenericTestMain(args, "even_odd_array.cc", "../test_data/epi/even_odd_array.tsv",
                         &EvenOddWrapper, DefaultComparator{}, param_names);
}
