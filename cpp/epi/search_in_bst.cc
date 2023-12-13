#include <memory>

#include "bst_node.h"
#include "generic_test.h"
using std::unique_ptr;

BstNode<int>* SearchBST(const unique_ptr<BstNode<int>>& tree, int key) {
  return nullptr;
}

int SearchBSTWrapper(const unique_ptr<BstNode<int>>& tree, int key) {
  auto result = SearchBST(tree, key);
  return result ? result->data : -1;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "SearchBST";
  std::vector<std::string> param_names{"tree", "key"};

  return GenericTestMain(args, "search_in_bst.cc",
                         "../test_data/epi/search_in_bst.tsv",
                         &SearchBSTWrapper, DefaultComparator{}, func_name, param_names);
}