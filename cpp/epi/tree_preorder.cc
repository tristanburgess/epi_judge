#include <memory>
#include <vector>
#include "../generic_types/binary_tree_node.h"
#include "generic_test.h"
using std::unique_ptr;
using std::vector;

void PreorderTraversalNaiveHelper(vector<int>& data, const unique_ptr<BinaryTreeNode<int>>& tree) {
  if (tree == nullptr) { 
    return;
  }

  data.emplace_back(tree->data);
  PreorderTraversalNaiveHelper(data, tree->left);
  PreorderTraversalNaiveHelper(data, tree->right);
}

vector<int> PreorderTraversalNaive(const unique_ptr<BinaryTreeNode<int>>& tree) {
  vector<int> data;
  PreorderTraversalNaiveHelper(data, tree);
  return data;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"tree"};
  std::string func_name = "PreorderTraversalNaive";

  return GenericTestMain(args, "tree_preorder.cc", "../test_data/epi/tree_preorder.tsv",
                         &PreorderTraversalNaive, DefaultComparator{}, func_name, param_names);
}
