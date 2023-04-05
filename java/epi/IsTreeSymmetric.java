package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsTreeSymmetric {

  private static boolean symHelper(BinaryTreeNode<Integer> l, BinaryTreeNode<Integer> r) {
    if (l == null && r == null) {
      return true;
    }

    return (
      l != null && r != null && 
        l.data == r.data && 
        symHelper(l.left, r.right) && 
        symHelper(l.right, r.left)
    );
  }

  @EpiTest(testDataFile = "../test_data/epi/is_tree_symmetric.tsv")
  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return true;
    }

    return symHelper(tree.left, tree.right);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeSymmetric.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
