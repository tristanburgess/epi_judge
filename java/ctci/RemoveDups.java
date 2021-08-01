package ctci;

import java.util.HashSet;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Two solutions, one with and without a buffer.
    - Input list is unsorted.
    - Assume a singly linked list.

    Solution 1: O(n) time O(n) space
    -----------
    Initialize a set whose value types are the type of the data of the list nodes.
    Walk through the list one node at a time. If the current node's element value is in the set,
    then remove the current node from the list. Else add the current node's value to the set.

    Solution 2: O(n^2) time O(1) space
    -----------
    For each element of the list, check all remaining elements of the list for duplicates. 
    Remove any found.
*/

public class RemoveDups {
  @EpiTest(testDataFile = "../test_data/ctci/remove_dups.tsv")
  public static ListNode<Integer> removeDupsNoBuf(ListNode<Integer> head) {
    if (head == null) {
      return head;
    }

    ListNode<Integer> cur = head;
    while (cur != null) {
      ListNode<Integer> run = cur;
      while (run.next != null) {
        if (run.next.data == cur.data) {
          run.next = run.next.next;
        } else {
          run = run.next;
        }
      }
      cur = cur.next;
    }

    return head;
  }

  @EpiTest(testDataFile = "../test_data/ctci/remove_dups.tsv")
  public static ListNode<Integer> removeDups(ListNode<Integer> head) {
    if (head == null) {
      return head;
    }
  
    HashSet<Integer> hs = new HashSet<Integer>();
    ListNode<Integer> cur = head;
    hs.add(cur.data);
  
    while (cur.next != null) {
      if (hs.contains(cur.next.data)) {
        cur.next = cur.next.next;
      } else {
        hs.add(cur.next.data);
        cur = cur.next;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "RemoveDups.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
