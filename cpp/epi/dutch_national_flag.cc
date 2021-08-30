#include <array>
#include <vector>

#include "generic_test.h"
#include "test_failure.h"
#include "timed_executor.h"
using std::swap;
using std::vector;
typedef enum { kRed, kWhite, kBlue } Color;

// O(n) time
// O(1) space
void DutchFlagPartition(int pivot_index, vector<Color>* A_ptr) {
  vector<Color>& A = *A_ptr;
  Color pivot = A[pivot_index];
  int lo = 0;
  int mid = 0;
  int hi = A.size() - 1;

  while (mid <= hi) {
    if (A[mid] < pivot) {
      swap(A[lo++], A[mid++]);
    } else if (A[mid] == pivot) {
      mid++;
    } else {
      swap(A[mid], A[hi--]);
    }
  }
}


// O(n) time
// O(1) space
void DutchFlagPartitionBF(int pivot_index, vector<Color>* A_ptr) {
  vector<Color>& A = *A_ptr;
  Color pivot = A[pivot_index];

  int lo = 0;
  for (int i = 0; i < A.size(); i++) {
    if (A[i] < pivot) {
      swap(A[lo++], A[i]);
    }
  }

  int hi = A.size() - 1;
  for (int i = A.size() - 1; i >= 0 && A[i] >= pivot; i--) {
    if (A[i] > pivot) {
      swap(A[i], A[hi--]);
    }
  }
}

void DutchFlagPartitionWrapper(TimedExecutor& executor, const vector<int>& A,
                               int pivot_idx) {
  vector<Color> colors;
  colors.resize(A.size());
  std::array<int, 3> count = {0, 0, 0};
  for (size_t i = 0; i < A.size(); i++) {
    count[A[i]]++;
    colors[i] = static_cast<Color>(A[i]);
  }
  Color pivot = colors[pivot_idx];

  executor.Run([&] { DutchFlagPartition(pivot_idx, &colors); });

  int i = 0;
  while (i < colors.size() && colors[i] < pivot) {
    count[colors[i]]--;
    ++i;
  }

  while (i < colors.size() && colors[i] == pivot) {
    count[colors[i]]--;
    ++i;
  }

  while (i < colors.size() && colors[i] > pivot) {
    count[colors[i]]--;
    ++i;
  }

  if (i != colors.size()) {
    throw TestFailure("Not partitioned after " + std::to_string(i) +
                      "th element");
  } else if (count != std::array<int, 3>{0, 0, 0}) {
    throw TestFailure("Some elements are missing from original array");
  }
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"executor", "A", "pivot_idx"};
  return GenericTestMain(args, "dutch_national_flag.cc",
                         "../test_data/epi/dutch_national_flag.tsv", &DutchFlagPartitionWrapper,
                         DefaultComparator{}, param_names);
}
