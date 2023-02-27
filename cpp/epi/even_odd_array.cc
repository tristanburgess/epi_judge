#include <set>
#include <vector>

#include "generic_test.h"
#include "test_failure.h"
#include "timed_executor.h"
using std::swap;
using std::vector;

void EvenOdd(vector<int>* A_ptr) {
  size_t A_begin = 0;
  size_t A_end = A_ptr->size() - 1;

  while (A_begin < A_end) {
    if (A_ptr->at(A_begin) % 2 == 0) {
      ++A_begin;
    } else {
      swap(A_ptr->at(A_begin), A_ptr->at(A_end--));
    }
  }
}

void EvenOddNaiveTwoPtr(vector<int>* A_ptr) {
  vector<int> res(A_ptr->size());
  size_t res_begin = 0;
  size_t res_end = res.size() - 1;

  for (size_t i = 0; i < A_ptr->size(); ++i) {
    if (A_ptr->at(i) % 2 == 0) {
      res[res_begin++] = A_ptr->at(i);
    } else {
      res[res_end--] = A_ptr->at(i);
    }
  }

  for (size_t i = 0; i < A_ptr->size(); ++i) {
    A_ptr->at(i) = res[i];
  }
}

void EvenOddNaive(vector<int>* A_ptr) {
  vector<int> res(A_ptr->size());
  size_t res_idx = 0;

  for (size_t i = 0; i < A_ptr->size(); ++i) {
    if (A_ptr->at(i) % 2 == 0) {
      res[res_idx++] = A_ptr->at(i);
    }
  }

  for (size_t i = 0; i < A_ptr->size(); ++i) {
    if (A_ptr->at(i) % 2 != 0) {
      res[res_idx++] = A_ptr->at(i);
    }
  }

  for (size_t i = 0; i < A_ptr->size(); ++i) {
    A_ptr->at(i) = res[i];
  }
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
  std::string func_name = "EvenOdd";
  std::vector<std::string> param_names{"executor", "A"};

  return GenericTestMain(args, "even_odd_array.cc",
                         "../test_data/epi/even_odd_array.tsv", &EvenOddWrapper,
                         DefaultComparator{}, func_name, param_names);
}
