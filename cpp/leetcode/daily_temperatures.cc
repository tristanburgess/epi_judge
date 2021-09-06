#include <stack>
#include <vector>

#include "generic_test.h"
using std::stack;
using std::vector;

vector<int> DailyTempsBF(const vector<int>& temperatures) {
  vector<int> answer;

  for (int i = 0; i < temperatures.size(); i++) {
    answer.emplace_back(0);
    for (int j = i + 1; j < temperatures.size(); j++) {
      if (temperatures[j] > temperatures[i]) {
        answer[i] = j - i;
        break;
      }
    }
  }

  return answer;
}

vector<int> DailyTemps(const vector<int>& temperatures) {
  vector<int> answer(temperatures.size());
  stack<int> stk;

  for (int i = 0; i < temperatures.size(); i++) {
    while (!stk.empty() && temperatures[i] > temperatures[stk.top()]) {
      int j = stk.top();
      stk.pop();
      answer[j] = i - j;
    }
    stk.push(i);
  }

  return answer;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"temperatures"};
  int r = GenericTestMain(args, "daily_temperatures.cc", "../test_data/leetcode/daily_temperatures.tsv",
                  &DailyTempsBF, DefaultComparator{}, param_names);
  if (r != 0) {
    return r;
  }
  r = GenericTestMain(args, "daily_temperatures.cc", "../test_data/leetcode/daily_temperatures.tsv",
                  &DailyTemps, DefaultComparator{}, param_names);
  return r;
}
