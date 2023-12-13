#include <memory>
#include <vector>
#include "../generic_types/binary_tree_node.h"
#include "generic_test.h"
using std::unique_ptr;
using std::vector;

vector<int> PreorderTraversalNaive(const unique_ptr<BinaryTreeNode<int>>& tree) {
  return {};
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::string func_name = "PreorderTraversalNaive";
  std::vector<std::string> param_names{"tree"};

  return GenericTestMain(args, "tree_preorder.cc", "../test_data/epi/tree_preorder.tsv",
                         &PreorderTraversalNaive, DefaultComparator{}, func_name, param_names);
}
