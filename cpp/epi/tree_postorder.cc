#include <memory>
#include <vector>
#include "../generic_types/binary_tree_node.h"
#include "generic_test.h"
using std::unique_ptr;
using std::vector;

void PostorderTraversalNaiveHelper(vector<int>& data, const unique_ptr<BinaryTreeNode<int>>& tree) {
  if (tree == nullptr) { 
    return;
  }

  PostorderTraversalNaiveHelper(data, tree->left);
  PostorderTraversalNaiveHelper(data, tree->right);
  data.emplace_back(tree->data);
}

vector<int> PostorderTraversalNaive(const unique_ptr<BinaryTreeNode<int>>& tree) {
  vector<int> data;
  PostorderTraversalNaiveHelper(data, tree);
  return data;
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"tree"};
  std::string func_name = "PostorderTraversalNaive";

  return GenericTestMain(args, "tree_postorder.cc", "../test_data/epi/tree_postorder.tsv",
                         &PostorderTraversalNaive, DefaultComparator{}, func_name, param_names);
}
