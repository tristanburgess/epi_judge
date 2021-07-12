package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TimedExecutor;

public class InsertInList {

  // Insert newNode after node.
  public static void insertAfter(ListNode<Integer> node,
                                 ListNode<Integer> newNode) {
    // TODO - you fill in here.
    return;
  }
  @EpiTest(testDataFile = "../test_data/epi/insert_in_list.tsv")
  public static ListNode<Integer>
  insertListWrapper(TimedExecutor executor, ListNode<Integer> l, int nodeIdx,
                    int newNodeData) throws Exception {
    ListNode<Integer> node = l;
    while (nodeIdx > 1) {
      node = node.next;
      --nodeIdx;
    }
    ListNode<Integer> newNode = new ListNode<Integer>(newNodeData, null);

    final ListNode<Integer> finalNode = node;
    executor.run(() -> insertAfter(finalNode, newNode));

    return l;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "InsertInList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
