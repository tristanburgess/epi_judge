package ctci;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - We are only given access to the singly linked list starting at the node we want to delete.
    - The list may be empty.
    - The list has no cycles.

    Solution: O(n) time, O(1) space
    ---------
    We basically have no choice but to make each node's value starting from mid until the tail node be the value
    of the node immediately after it, and then drop the tail node. This effectively deletes the input node without
    having access to the node previous to the one we want to delete.

    We should be weary about the edge case where the node to delete is the next-to-last node.

    a -> b -> c -> d
    b -> b -> c -> d
    b -> c -> c -> d
    b -> c -> d -> d
    b -> c -> d

    c -> d
    d -> d
    d

    Solution: O(1) time, O(1) space
    ---------
    Never mind, the above solution is basically right, except after the first iteration we can just delete the next
    node instead of iterating further to achieve the same effect.

    a -> b -> c -> d
    b -> b -> c -> d
    b -> c -> d

    c -> d
    d -> d
    d
*/

public class DeleteMiddleNode {
  public static void delMiddleWorker(ListNode<Character> mid) {
    // We can't delete anything if we've been handed
    // a null node or the last node of the list.
    if (mid == null || mid.next == null) {
      return;
    }
    
    mid.data = mid.next.data;
    mid.next = mid.next.next;
  }

  @EpiTest(testDataFile = "../test_data/ctci/delete_middle_node.tsv")
  public static ListNode<Character> delMiddleNode(ListNode<Character> head, int del) {
    ListNode<Character> cur = head;
    for (int i = 0; i < del; i++) {
      if (cur == null) {
        break;
      }
      cur = cur.next;
    }
    delMiddleWorker(cur);
    return head;
  }

  public static void delMiddleBFWorker(ListNode<Character> mid) {
    // We can't delete anything if we've been handed
    // a null node or the last node of the list.
    if (mid == null || mid.next == null) {
      return;
    }

    ListNode<Character> cur = mid;
    while (cur.next.next != null) {
      cur.data = cur.next.data;
      cur = cur.next;
    }

    // Since we return early upon mid being the last node,
    // our while loop ensures that cur.next is not null,
    // so this is safe.
    cur.data = cur.next.data;
    cur.next = null;
  }

  @EpiTest(testDataFile = "../test_data/ctci/delete_middle_node.tsv")
  public static ListNode<Character> delMiddleNodeBF(ListNode<Character> head, int del) {
    ListNode<Character> cur = head;
    for (int i = 0; i < del; i++) {
      if (cur == null) {
        break;
      }
      cur = cur.next;
    }
    delMiddleBFWorker(cur);
    return head;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "DeleteMiddleNode.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
