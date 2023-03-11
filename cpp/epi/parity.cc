#include "generic_test.h"

short Parity(unsigned long long x) {
  short p = 0;

  while (x != 0) {
    x = x & (x - 1);
    p ^= 1;
  }

  return p;
}

short ParityDC(unsigned long long x) {
  x ^= (x >> 32);
  x ^= (x >> 16);
  x ^= (x >> 8);
  x ^= (x >> 4);
  x ^= (x >> 2);
  x ^= (x >> 1);
  return x & 0x1;
}

short ParityTable(unsigned long long x) {
  short pt[65536];

  for (size_t i = 0; i < 65536; ++i) {
    pt[i] = Parity(i);
  }

  return (
    pt[x >> 48] ^ 
    pt[(x >> 32) & 0xFFFF] ^ 
    pt[(x >> 16) & 0xFFFF] ^ 
    pt[x & 0xFFFF]
  );
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "ParityDC";
  std::vector<std::string> param_names{"x"};

  return GenericTestMain(args, "parity.cc", "../test_data/epi/parity.tsv",
                         &ParityDC, DefaultComparator{}, func_name, param_names);
}
