#include <algorithm>
#include <vector>

#include "generic_test.h"
using std::swap;
using std::vector;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIEvCIapnX-IkujQzg

vector<int> WiggleSortBF(vector<int>& nums) {
  int n = nums.size();
  vector<int> res(n);
  sort(nums.begin(), nums.end());
  int s_idx = (n - 1) / 2;
  int l_idx = n - 1;
  for (int i = 0; i < n; i++) {
    if (i % 2 == 0) {
      res[i] = nums[s_idx--];
    } else {
      res[i] = nums[l_idx--];
    }
  }
  return res;
}

vector<int> WiggleSort(vector<int>& nums) {
  int n = nums.size();
  int mid = n / 2;

  nth_element(nums.begin(), nums.begin() + mid, nums.end());
  int i = 0;
  int j = 0;
  int m = n - 1;
  int k = nums[mid];
  while (j <= m) {
    if (nums[j] < k) {
      swap(nums[i++], nums[j++]);
    } else if (nums[j] > k) {
      swap(nums[j], nums[m--]);
    } else {
      j++;
    }
  }

  vector<int> res(n);
  int s_idx = (n % 2) ? mid : (mid - 1);
  int l_idx = n - 1;
  for (int i = 0; i < n; i++) {
    if (i % 2 == 0) {
      res[i] = nums[s_idx--];
    } else {
      res[i] = nums[l_idx--];
    }
  }

  return res;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"nums"};
  int r = GenericTestMain(args, "wiggle_sort_ii.cc",
                          "../test_data/leetcode/wiggle_sort_ii.tsv",
                          &WiggleSortBF, DefaultComparator{}, param_names);
  if (r != 0) {
    return r;
  }
  r = GenericTestMain(args, "wiggle_sort_ii.cc",
                      "../test_data/leetcode/wiggle_sort_ii.tsv", &WiggleSort,
                      DefaultComparator{}, param_names);
  return r;
}
