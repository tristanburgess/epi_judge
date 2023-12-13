package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TestFailure;
import test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeExterior {

  public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
    // TODO - you fill in here.
    return Collections.emptyList();
  }

  private static List<Integer> createOutputList(List<BinaryTreeNode<Integer>> L)
      throws TestFailure {
    if (L.contains(null)) {
      throw new TestFailure("Resulting list contains null");
    }
    List<Integer> output = new ArrayList<>();
    for (BinaryTreeNode<Integer> l : L) {
      output.add(l.data);
    }
    return output;
  }

  @EpiTest(testDataFile = "../test_data/epi/tree_exterior.tsv")
  public static List<Integer> exteriorBinaryTreeWrapper(TimedExecutor executor,
      BinaryTreeNode<Integer> tree) throws Exception {
    List<BinaryTreeNode<Integer>> result = executor.run(() -> exteriorBinaryTree(tree));

    return createOutputList(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeExterior.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
