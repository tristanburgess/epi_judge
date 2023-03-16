package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class TreePostorder {

  public static void postorderTraversalNaiveHelper(List<Integer> data, BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return;
    }

    postorderTraversalNaiveHelper(data, tree.left);
    postorderTraversalNaiveHelper(data, tree.right);
    data.add(tree.data);
  }

  // Naive bootcamp impl
  @EpiTest(testDataFile = "../test_data/epi/tree_postorder.tsv")
  public static List<Integer> postorderTraversalNaive(BinaryTreeNode<Integer> tree) {
    List<Integer> data = new ArrayList<Integer>();
    postorderTraversalNaiveHelper(data, tree);
    return data; 
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreePostorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
