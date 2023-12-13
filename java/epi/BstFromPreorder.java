package epi;

import generic_types.BstNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.List;

public class BstFromPreorder {
  @EpiTest(testDataFile = "../test_data/epi/bst_from_preorder.tsv")

  public static BstNode<Integer> rebuildBSTFromPreorder(List<Integer> preorderSequence) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BstFromPreorder.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
