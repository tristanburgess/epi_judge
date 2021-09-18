#include <string>

#include "../test_framework/generic_test.h"
using std::string;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE7sf4wKNIBnu_B9w

bool IsPalindromic(const string& s) {
  int i = 0;
  int j = s.size() - 1;
  while (i < j) {
    if (s[i] != s[j]) {
      return false;
    }
    i++;
    j--;
  }
  return true;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"s"};
  return GenericTestMain(args, "is_string_palindromic.cc",
                         "../test_data/epi/is_string_palindromic.tsv", &IsPalindromic,
                         DefaultComparator{}, param_names);
}