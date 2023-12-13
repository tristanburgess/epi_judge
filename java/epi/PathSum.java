package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class PathSum {
  @EpiTest(testDataFile = "../test_data/epi/path_sum.tsv")

  public static boolean hasPathSum(BinaryTreeNode<Integer> tree,
      int remainingWeight) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PathSum.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
