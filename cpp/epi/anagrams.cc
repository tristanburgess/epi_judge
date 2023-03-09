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

struct FreqMap {
  #define FREQ_MAP_SIZE 256

  bool operator==(const FreqMap& that) const {
    for (int i = 0; i < FREQ_MAP_SIZE; ++i) {
      if (freqs[i] != that.freqs[i]) {
        return false;
      }
    }

    return true;
  }

  size_t freqs[FREQ_MAP_SIZE];
};

struct FreqMapHash {
  size_t operator()(const FreqMap& freqs) const {
    size_t hash_code = 0;
    for (int i = 0; i < FREQ_MAP_SIZE; ++i) {
      hash_code ^= hash<string>()(char(i) + to_string(freqs.freqs[i]));
    }
    return hash_code;
  }
};

vector<vector<string>> FindAnagramsFreqMap(const vector<string>& dictionary) {
  unordered_map<FreqMap, vector<string>, FreqMapHash> map;
  vector<vector<string>> ans;

  for (const string word : dictionary) {
    FreqMap freqs = { 0 };
    for (char c : word) {
      freqs.freqs[c]++;
    }
    map[freqs].emplace_back(word);
  }

  for (auto e : map) {
    if (e.second.size() > 1) {
      ans.emplace_back(e.second);
    }
  }

  return ans;
}

vector<vector<string>> FindAnagramsSort(const vector<string>& dictionary) {
  unordered_map<string, vector<string>> map;
  vector<vector<string>> ans;

  for (const string word : dictionary) {
    string sorted(word);
    sort(sorted.begin(), sorted.end());
    map[sorted].emplace_back(word);
  }

  for (auto e : map) {
    if (e.second.size() > 1) {
      ans.emplace_back(e.second);
    }
  }

  return ans;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "FindAnagramsSort";
  std::vector<std::string> param_names{"dictionary"};

  return GenericTestMain(
      args, "anagrams.cc", "../test_data/epi/anagrams.tsv", &FindAnagramsSort,
      &UnorderedComparator<std::vector<std::vector<std::string>>>, func_name, param_names);
}
