package epi;

import generic_types.BstNode;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TestFailure;
import test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;

public class BstToSortedList {
  public static BstNode<Integer> bstToDoublyLinkedList(BstNode<Integer> tree) {
    // TODO - you fill in here.
    return null;
  }
  @EpiTest(testDataFile = "../test_data/epi/bst_to_sorted_list.tsv")
  public static List<Integer>
  bstToDoublyLinkedListWrapper(TimedExecutor executor, BstNode<Integer> tree)
      throws Exception {
    BstNode<Integer> list = executor.run(() -> bstToDoublyLinkedList(tree));

    if (list != null && list.left != null)
      throw new TestFailure(
          "Function must return the head of the list. Left link must be null");
    List<Integer> v = new ArrayList<>();
    while (list != null) {
      v.add(list.data);
      if (list.right != null && list.right.left != list)
        throw new RuntimeException("List is ill-formed");
      list = list.right;
    }
    return v;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BstToSortedList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
