#include <vector>

#include "generic_test.h"

using std::vector;

int MaxProfit(vector<int>& prices) {
  if (prices.size() < 2) {
    return 0;
  }

  int buy = prices[0];
  int profit = 0;

  for (int i = 1; i < prices.size(); i++) {
    if (prices[i] < buy) {
      buy = prices[i];
    } else if (prices[i] - buy > profit) {
      profit = prices[i] - buy;
    }
  }

  return profit;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"prices"};
  return GenericTestMain(args, "best_time_buy_sell_stock.cc",
                         "../test_data/leetcode/best_time_buy_sell_stock.tsv",
                         &MaxProfit, DefaultComparator{}, param_names);
}
