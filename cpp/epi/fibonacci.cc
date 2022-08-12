#include <vector>

#include "generic_test.h"
using std::vector;

int fib(int n) {
  // TODO - you fill in here.
  return 0;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"n"};

  return GenericTestMain(args, "fibonacci.cc", "../test_data/epi/fibonacci.tsv",
                      &fib, DefaultComparator{}, param_names);
}
