#include <string>

#include "../test_framework/generic_test.h"
using std::string;

bool IsPalindromic(const string& s) {
  return false;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "IsPalindromic";
  std::vector<std::string> param_names{"s"};

  return GenericTestMain(args, "is_string_palindromic.cc",
                         "../test_data/epi/is_string_palindromic.tsv", &IsPalindromic,
                         DefaultComparator{}, func_name, param_names);
}