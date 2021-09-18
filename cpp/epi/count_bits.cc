#include "generic_test.h"

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE4X-0ukpRgbTDMTg

short CountBitsBF(unsigned int x) {
  short count = 0;
  while (x != 0) {
    count += x & 1;
    x >>= 1;
  }
  return count;
}

short CountBits(unsigned int x) {
  short count = 0;
  while (x != 0) {
    x ^= (x & ~(x - 1));
    count++;
  }
  return count;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"x"};

  int r =
      GenericTestMain(args, "count_bits.cc", "../test_data/epi/count_bits.tsv",
                      &CountBitsBF, DefaultComparator{}, param_names);
  if (r != 0) {
    return r;
  }
  r = GenericTestMain(args, "count_bits.cc", "../test_data/epi/count_bits.tsv",
                      &CountBits, DefaultComparator{}, param_names);
  return r;
}
