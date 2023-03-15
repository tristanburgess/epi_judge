#include <string>
#include "generic_test.h"
#include "test_failure.h"
using std::string;

string IntToString(int x) {
  string s;
  bool sign = x < 0;

  do {
    s += (char)(abs(x % 10) + '0');
    x /= 10;
  } while (x != 0);

  if (sign) {
    s += '-';
  }

  return string(s.rbegin(), s.rend());
}

int StringToInt(const string& s) {
  if (s.size() == 0) {
    // would probably throw an exception here/return an error
    return 0;
  }

  int x = 0;
  size_t idx = 0;

  if (s[0] == '-') {
    idx = 1;
  }
  for (size_t i = idx; i < s.size(); ++i) {
    x = x * 10 + (int)(s[i] - '0');
  }
  if (s[0] == '-') {
    x = -x;
  }

  return x;
}

void Wrapper(int x, const string& s) {
  string xs = IntToString(x);
  if (xs != s) {
    std::ostringstream ss;
    ss << "\nInt to string conversion failed\n" << "Expected: " << s << " - Acutal: " << xs << "\n";
    throw TestFailure(ss.str());
  }

  int sx = StringToInt(s);
  if (sx != x) {
    std::ostringstream ss;
    ss << "\nString to int conversion failed\n" << "Expected: " << x << " - Acutal: " << sx << "\n";
    throw TestFailure(ss.str());
  }
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "IntToString,StringToInt";
  std::vector<std::string> param_names{"x", "s"};

  return GenericTestMain(args, "string_integer_interconversion.cc",
                         "../test_data/epi/string_integer_interconversion.tsv", &Wrapper,
                         DefaultComparator{}, func_name, param_names);
}
