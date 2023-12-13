package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.List;

public class TreeInorder {
  @EpiTest(testDataFile = "../test_data/epi/tree_inorder.tsv")
  public static List<Integer> inorderTraversalNaive(BinaryTreeNode<Integer> tree) {
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeInorder.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
