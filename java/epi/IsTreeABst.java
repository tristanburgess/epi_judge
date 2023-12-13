package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsTreeABst {

  @EpiTest(testDataFile = "../test_data/epi/is_tree_a_bst.tsv")
  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeABst.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
