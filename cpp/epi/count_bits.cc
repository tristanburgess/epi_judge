#include "generic_test.h"

short CountBits(unsigned int x) {
  short c = 0;

  while (x != 0) {
    ++c;
    x &= (x - 1);
  }

  return c;
}

short CountBitsCached(unsigned int x) {
  short a[256];
  for (unsigned int i = 0; i < 256; ++i) {
    a[i] = CountBits(i);
  }

  return a[(x >> 24) & 0xFF] +
          a[(x >> 16) & 0xFF] +
          a[(x >> 8) & 0xFF] +
          a[x & 0xFF];
}



int main(int argc, char* argv[]) {
  std::string func_name = "CountBits";
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"x"};

  GenericTestMain(args, "count_bits.cc", "../test_data/epi/count_bits.tsv",
                      &CountBits, DefaultComparator{}, func_name, param_names);
}
