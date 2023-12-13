package epi;

import generic_types.BstNode;
import test_framework.BinaryTreeUtils;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TimedExecutor;

public class DescendantAndAncestorInBst {

  public static boolean pairIncludesAncestorAndDescendantOfM(BstNode<Integer> possibleAncOrDesc0,
      BstNode<Integer> possibleAncOrDesc1,
      BstNode<Integer> middle) {
    // TODO - you fill in here.
    return true;
  }

  @EpiTest(testDataFile = "../test_data/epi/descendant_and_ancestor_in_bst.tsv")
  public static boolean pairIncludesAncestorAndDescendantOfMWrapper(
      TimedExecutor executor, BstNode<Integer> tree, int possibleAncOrDesc0,
      int possibleAncOrDesc1, int middle) throws Exception {
    final BstNode<Integer> candidate0 = BinaryTreeUtils.mustFindNode(tree, possibleAncOrDesc0);
    final BstNode<Integer> candidate1 = BinaryTreeUtils.mustFindNode(tree, possibleAncOrDesc1);
    final BstNode<Integer> middleNode = BinaryTreeUtils.mustFindNode(tree, middle);

    return executor.run(() -> pairIncludesAncestorAndDescendantOfM(
        candidate0, candidate1, middleNode));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DescendantAndAncestorInBst.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
