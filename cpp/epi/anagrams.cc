#include <algorithm>
#include <functional>
#include <string>
#include <unordered_map>
#include <vector>

#include "generic_test.h"

using std::hash;
using std::sort;
using std::string;
using std::to_string;
using std::unordered_map;
using std::vector;

vector<vector<string>> FindAnagrams(const vector<string>& dictionary) {
  return {};
}


int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "FindAnagrams";
  std::vector<std::string> param_names{"dictionary"};

  return GenericTestMain(
      args, "anagrams.cc", "../test_data/epi/anagrams.tsv", &FindAnagrams,
      &UnorderedComparator<std::vector<std::vector<std::string>>>, func_name, param_names);
}
