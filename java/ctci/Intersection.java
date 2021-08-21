package ctci;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - An intersection is defined by reference, where both lists share a sublist of common linked list nodes
    - Either lists empty means no intersection is possible
    - There can only be one intersection, and all nodes after and including the intersecting node must be shared between
    the two lists.

    Solution - O(A + B) time, O(1) space
    --------
      - Chop nodes off of both lists until they're of equal length
      - Return the first node with a common address between the two lists
      - If none exists, then we will hit the end of both lists anyways and return null
*/

public class Intersection {
  public static ListNode<Integer> intersection(ListNode<Integer> l1, ListNode<Integer> l2) {
    if (l1 == null || l2 == null) {
      return null;
    }

    int lenL1 = llLen(l1);
    int lenL2 = llLen(l2);
    if (lenL1 > lenL2) {
      int diff = lenL1 - lenL2;
      for (int i = 0; i < diff; i++) {
        l1 = l1.next;
      }
    } else {
      int diff = lenL2 - lenL1;
      for (int i = 0; i < diff; i++) {
        l2 = l2.next;
      }
    }

    while (l1 != null && l1 != l2) {
      l1 = l1.next;
      l2 = l2.next;
    }

    return l1;
  }

  public static int llLen(ListNode<Integer> l) {
    int len = 0;
    while (l != null) {
      len++;
      l = l.next;
    }
    return len;
  }

  @EpiTest(testDataFile = "../test_data/ctci/intersection.tsv")
  public static ListNode<Integer> intersectionWrapper(ListNode<Integer> l1, ListNode<Integer> l2, int i1, int i2) {
    ListNode<Integer> li1 = l1;
    ListNode<Integer> li2 = null;
    ListNode<Integer> liCur = null;
    if (i2 != -1) {
      // Fulfills a test case where l2 should have an intersection with l1.
      // Creates a new intersecting list where the first i2 elements are distinct from
      // any element in l1
      // and the remaining elements are shared with l1.
      while (i2 > 0) {
        ListNode<Integer> liTail = new ListNode<Integer>(l2.data, null);
        if (li2 == null) {
          li2 = liTail;
        }
        if (liCur != null) {
          liCur.next = liTail;
        }
        liCur = liTail;
        l2 = l2.next;
        i2--;
      }
      while (i1 > 0) {
        l1 = l1.next;
        i1--;
      }
      while (l1 != null) {
        ListNode<Integer> liTail = l1;
        if (li2 == null) {
          li2 = liTail;
        }
        if (liCur != null) {
          liCur.next = liTail;
        }
        liCur = liTail;
        l1 = l1.next;
      }
    } else {
      // Fulfills a test case where l2 should have no intersection with l1.
      li2 = l2;
    }

    return intersection(li1, li2);
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "Intersection.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
