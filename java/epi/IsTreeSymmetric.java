package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsTreeSymmetric {

  @EpiTest(testDataFile = "../test_data/epi/is_tree_symmetric.tsv")
  public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeSymmetric.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
