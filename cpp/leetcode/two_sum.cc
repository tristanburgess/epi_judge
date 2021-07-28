#include <unordered_map>
#include <vector>

#include "generic_test.h"
using std::unordered_map;
using std::vector;

vector<int> TwoSumBF(const vector<int>& nums, int target) {
  vector<int> found_idxs;

  for (int i = 0; i < nums.size(); i++) {
    for (int j = i + 1; j < nums.size(); j++) {
      if (nums[i] + nums[j] == target) {
        found_idxs.emplace_back(i);
        found_idxs.emplace_back(j);
        break;
      }
    }
  }

  return found_idxs;
}

vector<int> TwoSum(const vector<int>& nums, int target) {
  vector<int> found_idxs;
  unordered_map<int, int> num_idx_map;

  // At every iteration, we are either adding
  // nums[i] to the map, or finding a previously
  // added element. Thus we won't return a solution with
  // two of the same indexes.
  for (int i = 0; i < nums.size(); i++) {
    auto comp = num_idx_map.find(target - nums[i]);
    if (comp != num_idx_map.end()) {
      found_idxs.emplace_back(comp->second);
      found_idxs.emplace_back(i);
      break;
    } else {
      num_idx_map.emplace(nums[i], i);
    }
  }

  return found_idxs;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"nums", "target"};
  int r = GenericTestMain(args, "two_sum.cc", "../test_data/leetcode/two_sum.tsv",
                  &TwoSumBF, DefaultComparator{}, param_names);
  if (r != 0) {
    return r;
  }
  r = GenericTestMain(args, "two_sum.cc", "../test_data/leetcode/two_sum.tsv",
                  &TwoSum, DefaultComparator{}, param_names);
  return r;
}
