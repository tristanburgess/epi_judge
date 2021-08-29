
#include "generic_test.h"

// O(n) time where n is the number of 1 bits in x
// O(1) space
short Parity(unsigned long long x) {
  short p = 0;
  while (x != 0) {
    p ^= 1;
    x ^= x & ~(x - 1);
  }
  return p;
}

// In the below statements, for our implementation, n = 64, k = 16.
// O(n/k) time to lookup, where n is the input size in bits and k is the caching
// word size in bits. O(2^k) time to build the table, where k is the caching
// word size in bits. O(2^k) space where k is the caching word size in bits.
short ParityTable(unsigned long long x) {
  const int pTableSize = 0xFFFF;
  short pTable[pTableSize];
  for (int i = 0; i < pTableSize; i++) {
    pTable[i] = Parity(i);
  }

  return pTable[x >> 48] ^ pTable[(x >> 32) & pTableSize] ^
         pTable[(x >> 16) & pTableSize] ^ pTable[x & pTableSize];
}

// O(lg(x)) time
// O(1) space
short ParityDivideConquer(unsigned long long x) {
  x ^= (x >> 32);
  x ^= (x >> 16);
  x ^= (x >> 8);
  x ^= (x >> 4);
  x ^= (x >> 2);
  x ^= (x >> 1);
  return x & 0x1;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"x"};
  return GenericTestMain(args, "parity.cc", "../test_data/epi/parity.tsv",
                         &Parity, DefaultComparator{}, param_names);
}
