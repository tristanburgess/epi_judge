#include "../test_framework/generic_test.h"

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE_HeVtU98cFvo0PQ

long long gcd(long long x, long long y) {
  if (y == 0) {
    return x;
  } else {
    return gcd(y, x % y);
  }
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"x", "y"};
  return GenericTestMain(args, "euclidean_gcd.cc", "../test_data/epi/gcd.tsv", &gcd,
                         DefaultComparator{}, param_names);
}
