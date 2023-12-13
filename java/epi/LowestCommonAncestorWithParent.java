package epi;

import generic_types.BinaryTree;
import test_framework.BinaryTreeUtils;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TestFailure;
import test_framework.TimedExecutor;

public class LowestCommonAncestorWithParent {

  public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
      BinaryTree<Integer> node1) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTest(testDataFile = "../test_data/epi/lowest_common_ancestor.tsv")
  public static int lcaWrapper(TimedExecutor executor, BinaryTree<Integer> tree,
      Integer key0, Integer key1) throws Exception {
    BinaryTree<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
    BinaryTree<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

    BinaryTree<Integer> result = executor.run(() -> LCA(node0, node1));

    if (result == null) {
      throw new TestFailure("Result can not be null");
    }
    return result.data;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LowestCommonAncestorWithParent.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
