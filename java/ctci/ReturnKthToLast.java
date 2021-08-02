package ctci;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Assume length of list is not known
    - Assume that k = 1 means the first to last element, meaning the last element.

    Recursive solution: O(n) time O(n) space
    ------------------
    Init counter to 0.
    If head is null k is too large, return null.
    Recursive call to the next node keeping counter and k the same.
    Stack unwind begins at last node, increments counter.
    If counter is k then that is the kth last node.

    Iterate length, then traverse till len - k:  O(n) time O(1) space
    ------------------------------------------

    Slightly different: O(n) time O(1) space
    -------------------
    Pointer at first node and kth node, then when the kth node reaches past the end of the list,
    the first node pointer will be at the node at list.length - k.
*/

class Index {
  public int val = 0;
}

public class ReturnKthToLast {
  public static ListNode<Integer> recurWorker(ListNode<Integer> head, int k, Index i) {
    if (head == null) {
      return head;
    }
    ListNode<Integer> next = recurWorker(head.next, k, i);
    i.val += 1;
    if (i.val == k) {
      return new ListNode<Integer>(head.data, null);
    }
    return next;
  }

  @EpiTest(testDataFile = "../test_data/ctci/return_kth_to_last.tsv")
  public static ListNode<Integer> recurKthToLast(ListNode<Integer> head, int k) {
    ListNode<Integer> kth = recurWorker(head, k, new Index());
    return kth;
  }

  @EpiTest(testDataFile = "../test_data/ctci/return_kth_to_last.tsv")
  public static ListNode<Integer> returnKthToLastOpt(ListNode<Integer> head, int k) {
    if (head == null) {
      return null;
    }

    ListNode<Integer> kth = head;
    for (int i = 0; i < k; i++) {
      if (kth == null) {
        return null;
      }
      kth = kth.next;
    }

    ListNode<Integer> cur = head;
    while (kth != null) {
      cur = cur.next;
      kth = kth.next;
    }

    return new ListNode<Integer>(cur.data, null);
  }

  @EpiTest(testDataFile = "../test_data/ctci/return_kth_to_last.tsv")
  public static ListNode<Integer> returnKthToLast(ListNode<Integer> head, int k) {
    if (head == null) {
      return null;
    }

    int len = 0;
    ListNode<Integer> cur = head;
    while (cur != null) {
      len++;
      cur = cur.next;
    }

    if (k > len) {
      return null;
    }

    cur = head;
    for (int i = 1; i < len - (k - 1); i++) {
      cur = cur.next;
    }
    return new ListNode<Integer>(cur.data, null);
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "ReturnKthToLast.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
