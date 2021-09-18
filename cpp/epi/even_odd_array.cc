#include <set>
#include <vector>

#include "generic_test.h"
#include "test_failure.h"
#include "timed_executor.h"
using std::swap;
using std::vector;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE62croc5SJEGoR-Q

void EvenOdd(vector<int>* A_ptr) {
  vector<int>& A = *A_ptr;
  int i = 0;
  int j = A.size() - 1;
  while (i < j) {
    if (A[j] % 2 == 1) {
      j--;
    } else if (A[i] % 2 == 1) {
      swap(A[i], A[j--]);
    } else {
      i++;
    }
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
  std::vector<std::string> param_names{"executor", "A"};
  return GenericTestMain(args, "even_odd_array.cc",
                         "../test_data/epi/even_odd_array.tsv", &EvenOddWrapper,
                         DefaultComparator{}, param_names);
}
