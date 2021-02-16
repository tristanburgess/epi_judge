#include <string>
#include "generic_test.h"
#include "test_failure.h"
using std::string;

string IntToString(int x) {
  // TODO - you fill in here.
  return "0";
}

int StringToInt(const string& s) {
  // TODO - you fill in here.
  return 0;
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
  std::vector<std::string> param_names{"x", "s"};
  return GenericTestMain(args, "string_integer_interconversion.cc",
                         "../test_data/epi/string_integer_interconversion.tsv", &Wrapper,
                         DefaultComparator{}, param_names);
}
