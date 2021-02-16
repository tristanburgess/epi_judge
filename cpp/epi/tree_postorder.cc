#include <memory>
#include <vector>
#include "../generic_types/binary_tree_node.h"
#include "generic_test.h"
using std::unique_ptr;
using std::vector;

vector<int> PostorderTraversal(const unique_ptr<BinaryTreeNode<int>>& tree) {
  // TODO - you fill in here.
  return {};
}

int main(int argc, char* argv[]) {
  std::vector<std::string> args{argv + 1, argv + argc};
  std::vector<std::string> param_names{"tree"};
  return GenericTestMain(args, "tree_postorder.cc", "../test_data/epi/tree_postorder.tsv",
                         &PostorderTraversal, DefaultComparator{}, param_names);
}
