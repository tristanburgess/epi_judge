package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TimedExecutor;

public class DeleteFromList {

  // Delete the node immediately following node. Assumes node is not a tail.
  public static void deleteAfter(ListNode<Integer> node) {
  }

  @EpiTest(testDataFile = "../test_data/epi/delete_from_list.tsv")
  public static ListNode<Integer> deleteListWrapper(TimedExecutor executor, ListNode<Integer> head, int nodeIdx)
      throws Exception {
    ListNode<Integer> nodeToDelete = head;
    ListNode<Integer> prev = null;

    if (nodeToDelete == null)
      throw new RuntimeException("List is empty");
    while (nodeIdx-- > 0) {
      if (nodeToDelete.next == null)
        throw new RuntimeException("Can't delete last node");
      prev = nodeToDelete;
      nodeToDelete = nodeToDelete.next;
    }

    final ListNode<Integer> finalPrev = prev;

    executor.run(() -> deleteAfter(finalPrev));

    return head;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteFromList.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}