package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class SumRootToLeaf {
  @EpiTest(testDataFile = "../test_data/epi/sum_root_to_leaf.tsv")

  public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SumRootToLeaf.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
