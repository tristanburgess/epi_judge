#include <limits.h>

#include "generic_test.h"

int Reverse(int x) {
  int r = 0;

  while (x != 0) {
    if (r > INT_MAX / 10 || r < INT_MIN / 10) {
      return 0;
    }
    int digit = x % 10;
    r *= 10;
    r += digit;
    x /= 10;
  }

  return r;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"x"};
  return GenericTestMain(args, "reverse_integer.cc",
                         "../test_data/leetcode/reverse_integer.tsv", &Reverse,
                         DefaultComparator{}, param_names);
}
