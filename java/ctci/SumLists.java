package ctci;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Each node's data is an integer 0 <= x <= 9
    - No integer other than 0 has a leading zero in its linked list representation
    - Digits are represented with increasing weight from the head to the tail

    Solution: O(d) time O(d) space, where 
      d is the number of digits in the larger of the two numbers between l1 and l2.
    --------
      - Initialize result list head to null
      - While any of the lists have an element or there is leftover carry
        - Compute a sum of the current node's digit from each list that has remaining elements, plus the carry
        - Create a new node with the value of the least significant digit of that sum and add to the result list
        - Set the carry to sum / 10. Since node data are guaranteed to be 0-9, carry can only be 0 or 1 since 0 <= sum <= 18
        - Iterate to the next node for any lists for which we have not yet reached its end

    Follow on solution: O(d) time O(d) space
    ------------------
      - Pad the shorter list with leading zeroes so both lists are of equal length.
      - Recurse to the end of the lists and begin unwinding, adding a new list node and keeping track of the carry
      as we work backwards.
*/

class PartialSum {
  public ListNode<Integer> sum = null;
  public int carry = 0;
}

public class SumLists {
  @EpiTest(testDataFile = "../test_data/ctci/sum_lists.tsv")
  public static ListNode<Integer> sumLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> head = null;
    ListNode<Integer> cur = null;
    int c = 0;

    while (l1 != null || l2 != null || c != 0) {
      int sum = c;
      if (l1 != null) {
        sum += l1.data;
      }
      if (l2 != null) {
        sum += l2.data;
      }
      int d = sum % 10;
      c = sum / 10;
      ListNode<Integer> node = new ListNode<Integer>(d, null);
      if (head == null) {
        head = node;
        cur = head;
      } else {
        cur.next = node;
        cur = cur.next;
      }
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    return head;
  }

  @EpiTest(testDataFile = "../test_data/ctci/sum_lists_forward.tsv")
  public static ListNode<Integer> sumListsForward(ListNode<Integer> l1, ListNode<Integer> l2) {
    int len1 = listLength(l1);
    int len2 = listLength(l2);

    if (len1 < len2) {
      l1 = padList(l1, len2 - len1);
    } else {
      l2 = padList(l2, len1 - len2);
    }

    PartialSum sum = sumListsForwardHelper(l1, l2);

    if (sum.carry == 0) {
      return sum.sum;
    } else {
      return new ListNode<Integer>(sum.carry, sum.sum);
    }
  }

  public static PartialSum sumListsForwardHelper(ListNode<Integer> l1, ListNode<Integer> l2) {
    if (l1 == null && l2 == null) {
      return new PartialSum();
    }

    PartialSum sum = sumListsForwardHelper(l1.next, l2.next);
    int s = sum.carry + l1.data + l2.data;
    ListNode<Integer> full = new ListNode<Integer>(s % 10, sum.sum);
    sum.sum = full;
    sum.carry = s / 10;
    return sum;
  }

  public static int listLength(ListNode<Integer> l) {
    int len = 0;

    while (l != null) {
      len++;
      l = l.next;
    }

    return len;
  }

  public static ListNode<Integer> padList(ListNode<Integer> head, int padLen) {
    ListNode<Integer> curHead = head;

    for (int i = 0; i < padLen; i++) {
      ListNode<Integer> nHead = new ListNode<Integer>(0, curHead);
      curHead = nHead;
    }

    return curHead;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "SumLists.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
