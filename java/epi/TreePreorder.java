package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class TreePreorder {

  public static void preorderTraversalNaiveHelper(List<Integer> data, BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return;
    }

    data.add(tree.data);
    preorderTraversalNaiveHelper(data, tree.left);
    preorderTraversalNaiveHelper(data, tree.right);
  }

  // Naive bootcamp impl
  @EpiTest(testDataFile = "../test_data/epi/tree_preorder.tsv")
  public static List<Integer> preorderTraversalNaive(BinaryTreeNode<Integer> tree) {
    List<Integer> data = new ArrayList<Integer>();
    preorderTraversalNaiveHelper(data, tree);
    return data; 
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreePreorder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
