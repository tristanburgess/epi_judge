#include <vector>

#include "generic_test.h"
using std::vector;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIFABCzzLYB-JQ9tMQ

int fibr(int n) {
  if (n <= 1) {
    return n;
  }
  return fibr(n - 2) + fibr(n - 1);
}

int fibrc_helper(int n, vector<int>& cache) {
  if (n <= 1) {
    return n;
  }

  if (cache[n] == 0) {
    cache[n] = fibrc_helper(n - 2, cache) + fibrc_helper(n - 1, cache);
  }

  return cache[n];
}

int fibrc(int n) {
  vector<int> cache(n + 1);
  return fibrc_helper(n, cache);
}

int fib(int n) {
  if (n <= 1) {
    return n;
  }

  int a = 0;
  int b = 1;

  for (int i = 2; i <= n; i++) {
    int tmp = a;
    a = b;
    b += tmp;
  }

  return b;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"n"};
  /*int r =
      GenericTestMain(args, "fibonacci.cc", "../test_data/epi/fibonacci.tsv",
                      &fibr, DefaultComparator{}, param_names);
  if (r != 0) {
    return r;
  }*/
  int r =
      GenericTestMain(args, "fibonacci.cc", "../test_data/epi/fibonacci.tsv",
                      &fibrc, DefaultComparator{}, param_names);
  if (r != 0) {
    return r;
  }
  r = GenericTestMain(args, "fibonacci.cc", "../test_data/epi/fibonacci.tsv",
                      &fib, DefaultComparator{}, param_names);
  return r;
}
