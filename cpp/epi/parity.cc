#include "generic_test.h"

short Parity(unsigned long long x) {
  return 0;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "Parity";
  std::vector<std::string> param_names{"x"};

  return GenericTestMain(args, "parity.cc", "../test_data/epi/parity.tsv",
                         &Parity, DefaultComparator{}, func_name, param_names);
}
