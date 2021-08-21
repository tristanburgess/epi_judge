package ctci;

import java.util.Stack;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - An empty list is not a palindrome since it is not representing any data type value.
    - A list containing a single element is a palindrome.
    - List elemenets contain integer values.

    All below are O(n) time O(n) space

    Solution 1: Reverse LL and compare
    ----------

    Solution 2: Add LL data to explicit stack and compare
    ----------

    Solution 3: Add LL data to implicit stack (recurse) and compare
    ----------
*/

class Result {
  public ListNode<Integer> node;
  public boolean res;

  public Result(ListNode<Integer> node, boolean res) {
    this.node = node;
    this.res = res;
  }
}

public class Palindrome {
  @EpiTest(testDataFile = "../test_data/ctci/palindrome.tsv")
  public static boolean isPalindromeReverse(ListNode<Integer> l) {
    if (l == null) {
      return false;
    }

    ListNode<Integer> rHead = null;
    ListNode<Integer> rCur = null;
    ListNode<Integer> cur = l;

    while (cur != null) {
      rHead = new ListNode<Integer>(cur.data, rCur);
      rCur = rHead;
      cur = cur.next;
    }

    cur = l;
    while (cur != null) {
      if (cur.data != rCur.data) {
        return false;
      }
      cur = cur.next;
      rCur = rCur.next;
    }

    return true;
  }

  @EpiTest(testDataFile = "../test_data/ctci/palindrome.tsv")
  public static boolean isPalindromeStack(ListNode<Integer> l) {
    if (l == null) {
      return false;
    }

    ListNode<Integer> cur = l;
    ListNode<Integer> runner = l;
    Stack<Integer> stk = new Stack<Integer>();

    while (runner != null && runner.next != null) {
      stk.push(cur.data);
      cur = cur.next;
      runner = runner.next.next;
    }

    // Odd number of elements, skip
    if (runner != null) {
      cur = cur.next;
    }

    while (cur != null) {
      if (stk.pop() != cur.data) {
        return false;
      }
      cur = cur.next;
    }

    return true;
  }

  @EpiTest(testDataFile = "../test_data/ctci/palindrome.tsv")
  public static boolean isPalindromeRecurse(ListNode<Integer> l) {
    if (l == null) {
      return false;
    }

    int len = llLen(l);
    Result r = isPalindromeRecurseHelper(l, len);
    return r.res;
  }

  public static Result isPalindromeRecurseHelper(ListNode<Integer> l, int len) {
    if (l == null || len <= 0) {
      return new Result(l, true);
    } else if (len == 1) {
      return new Result(l.next, true);
    }

    Result r = isPalindromeRecurseHelper(l.next, len - 2);

    // Propagate false comparisons up the stack.
    if (!r.res || r.node == null) {
      return r;
    }

    r.res = l.data == r.node.data;
    r.node = r.node.next;

    return r;
  }

  public static int llLen(ListNode<Integer> l) {
    int len = 0;
    while (l != null) {
      len++;
      l = l.next;
    }
    return len;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "Palindrome.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
