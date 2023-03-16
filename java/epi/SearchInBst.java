package epi;
import generic_types.BstNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class SearchInBst {

  public static BstNode<Integer> searchBST(BstNode<Integer> tree, int key) {
    if (tree == null) {
      return null;
    }

    if (tree.data == key) {
      return tree;
    } else if (tree.data > key) {
      return searchBST(tree.left, key);
    } else {
      return searchBST(tree.right, key);
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/search_in_bst.tsv")
  public static int searchBSTWrapper(BstNode<Integer> tree, int key) {
    BstNode<Integer> result = searchBST(tree, key);
    return result != null ? result.data : -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchInBst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
