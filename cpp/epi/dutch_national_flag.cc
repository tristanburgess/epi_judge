#include <array>
#include <vector>

#include "generic_test.h"
#include "test_failure.h"
#include "timed_executor.h"
using std::swap;
using std::vector;
typedef enum { kRed, kWhite, kBlue } Color;

void DutchFlagPartition(int pivot_index, vector<Color>* A_ptr) {
  vector<Color>& A = *A_ptr;
  Color pivot = A[pivot_index];

  int s = 0;
  int e = 0;
  int l = A.size();

  while (e < l) {
    if (A[e] == pivot) {
      ++e;
    } else if (A[e] > pivot) {
      swap(A[e], A[--l]);
    } else if (s != e) {
      swap(A[s++], A[e++]);
    } else {
      ++s;
      ++e;
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
  std::string func_name = "DutchFlagParition";
  std::vector<std::string> param_names{"executor", "A", "pivot_idx"};

  return GenericTestMain(args, "dutch_national_flag.cc",
                         "../test_data/epi/dutch_national_flag.tsv", &DutchFlagPartitionWrapper,
                         DefaultComparator{}, func_name, param_names);
}
