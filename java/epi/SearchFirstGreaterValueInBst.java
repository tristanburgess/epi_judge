package epi;

import generic_types.BstNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class SearchFirstGreaterValueInBst {

  private static BstNode<Integer> findRecurHelper(BstNode<Integer> tree, 
                                                  Integer k, 
                                                  BstNode<Integer> candidate) {
    if (tree == null) {
      return candidate;
    }

    if (tree.data <= k) {
      return findRecurHelper(tree.right, k, candidate);
    }

    return findRecurHelper(tree.left, k, tree);
  }

  public static BstNode<Integer> findFirstGreaterThanKRecur(BstNode<Integer> tree,
                                                            Integer k) {
      return findRecurHelper(tree, k, null);                                                    
  }

  public static BstNode<Integer> findFirstGreaterThanK(BstNode<Integer> tree,
                                                      Integer k) {
    BstNode<Integer> candidate = null;
    
    while (tree != null) {
      if (tree.data <= k) {
        tree = tree.right;
      } else {
        candidate = tree;
        tree = tree.left;
      }
    }

    return candidate;
  }

  @EpiTest(testDataFile = "../test_data/epi/search_first_greater_value_in_bst.tsv")
  public static int findFirstGreaterThanKWrapper(BstNode<Integer> tree,
                                                 Integer k) {
    BstNode<Integer> result = findFirstGreaterThanK(tree, k);
    return result != null ? result.data : -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchFirstGreaterValueInBst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
