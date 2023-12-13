package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.List;

public class TreePreorder {
  @EpiTest(testDataFile = "../test_data/epi/tree_preorder.tsv")
  public static List<Integer> preorderTraversalNaive(BinaryTreeNode<Integer> tree) {
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreePreorder.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
