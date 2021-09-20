#include <string>
#include <unordered_map>
#include <vector>

#include "generic_test.h"

using std::string;
using std::unordered_map;
using std::vector;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE9n2uBFaY6a3mGPw

vector<vector<string>> FindAnagrams(const vector<string>& dictionary) {
  unordered_map<string, vector<string>> string_to_anagram_map;
  for (const string& s : dictionary) {
    string sorted_s(s);
    sort(sorted_s.begin(), sorted_s.end());
    string_to_anagram_map[sorted_s].emplace_back(s);
  }

  vector<vector<string>> anagrams;
  for (const auto& p : string_to_anagram_map) {
    if (p.second.size() >= 2) {
      anagrams.emplace_back(p.second);
    }
  }

  return anagrams;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"dictionary"};
  return GenericTestMain(
      args, "anagrams.cc", "../test_data/epi/anagrams.tsv", &FindAnagrams,
      &UnorderedComparator<std::vector<std::vector<std::string>>>, param_names);
}
