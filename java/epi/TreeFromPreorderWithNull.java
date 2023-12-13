package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;

public class TreeFromPreorderWithNull {
  public static BinaryTreeNode<Integer> reconstructPreorder(List<Integer> preorder) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTest(testDataFile = "../test_data/epi/tree_from_preorder_with_null.tsv")
  public static BinaryTreeNode<Integer> reconstructPreorderWrapper(TimedExecutor executor, List<String> strings)
      throws Exception {
    List<Integer> ints = new ArrayList<>();
    for (String s : strings) {
      if (s.equals("null")) {
        ints.add(null);
      } else {
        ints.add(Integer.parseInt(s));
      }
    }

    return executor.run(() -> reconstructPreorder(ints));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeFromPreorderWithNull.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
