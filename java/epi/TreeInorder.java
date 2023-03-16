package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class TreeInorder {

  public static void inorderTraversalNaiveHelper(List<Integer> data, BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return;
    }

    inorderTraversalNaiveHelper(data, tree.left);
    data.add(tree.data);
    inorderTraversalNaiveHelper(data, tree.right);
  }

  // Naive bootcamp impl
  @EpiTest(testDataFile = "../test_data/epi/tree_inorder.tsv")
  public static List<Integer> inorderTraversalNaive(BinaryTreeNode<Integer> tree) {
    List<Integer> data = new ArrayList<Integer>();
    inorderTraversalNaiveHelper(data, tree);
    return data; 
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeInorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
