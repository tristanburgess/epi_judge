#include <stack>
#include <string>

#include "generic_test.h"

using std::stack;
using std::string;

bool IsValid(string s) {
  stack<char> closes;
  for (char c : s) {
    switch (c) {
      case '(':
        closes.push(')');
        break;
      case '{':
        closes.push('}');
        break;
      case '[':
        closes.push(']');
        break;
      default:
        if (closes.empty() || closes.top() != c) {
          return false;
        }
        closes.pop();
    }
  }
  return closes.empty();
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"s"};
  return GenericTestMain(args, "valid_parentheses.cc",
                         "../test_data/leetcode/valid_parentheses.tsv",
                         &IsValid, DefaultComparator{}, param_names);
}
