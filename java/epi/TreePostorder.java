package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.List;

public class TreePostorder {
  @EpiTest(testDataFile = "../test_data/epi/tree_postorder.tsv")
  public static List<Integer> postorderTraversalNaive(BinaryTreeNode<Integer> tree) {
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreePostorder.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
