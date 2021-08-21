package ctci;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Must return the data of the first node in the cycle, not just detect that there was a loop
    - Not guaranteed to have a loop

    Solution: O(n) time O(1) space
    ---------
      Maintain a fast and slow pointer. Slow traverses by 1, fast traverses by 2.
      If fast hits any nulls then there's no cycle as we hit the end of the list somewhere.
      Otherwise fast and slow are guaranteed to meet up, since in n iterations fast will visit all n nodes.
      When fast and slow do meet up, they will be k nodes from the start of the cycle, where k is the length of the
      non-cycle part of the list.
      Reset one of the pointers to the start of the list and iterate both pointers until they meet again.
*/

public class LoopDetection {
  public static int detectLoop(ListNode<Integer> l) {
    ListNode<Integer> slow = l;
    ListNode<Integer> fast = l;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        slow = l;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow.data;
      }
    }

    return -1;
  }

  @EpiTest(testDataFile = "../test_data/ctci/loop_detection.tsv")
  public static int detectLoopWrapper(ListNode<Integer> l, int c) {
    if (c != -1) {
      ListNode<Integer> cycleStart = null;
      ListNode<Integer> cur = l;
      for (int i = 0; i < c; i++) {
        cur = cur.next;
      }
      cycleStart = cur;
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = cycleStart;
    }

    return detectLoop(l);
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "LoopDetection.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
