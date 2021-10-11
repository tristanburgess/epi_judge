#include <memory>

#include "bst_node.h"
#include "generic_test.h"
using std::unique_ptr;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE-PJX6teIrNjxZeg

BstNode<int>* SearchBST(const unique_ptr<BstNode<int>>& tree, int key) {
  if (tree == nullptr) {
    return nullptr;
  }

  if (key < tree->data) {
    return SearchBST(tree->left, key);
  } else if (key > tree->data) {
    return SearchBST(tree->right, key);
  } else {
    return tree.get();
  }
}

int SearchBSTWrapper(const unique_ptr<BstNode<int>>& tree, int key) {
  auto result = SearchBST(tree, key);
  return result ? result->data : -1;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"tree", "key"};
  return GenericTestMain(args, "search_in_bst.cc",
                         "../test_data/epi/search_in_bst.tsv",
                         &SearchBSTWrapper, DefaultComparator{}, param_names);
}