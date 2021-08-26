package ctci;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import test_framework.TestFailure;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/*  MY ANSWERS:

    Requirements
    ------------
      - O(1) time for push, pop, and min operations
      - Dynamic capacity, no fixed allocation

    Solution: O(1) time for each operation
      - If we store a global min and update it on each push, we lose prior min information when we pop()
      - Thus, we need to store local mins in a separate stack, which becomes the current global min as we pop()
*/

public class StackMin {
  public static class StackWithMin {
    ListNode<Integer> head;
    Stack<Integer> mins;

    public StackWithMin() {
      head = null;
      mins = new Stack<Integer>();
    }

    public void push(int val) {
      if (val <= min()) {
        mins.push(val);
      }
      ListNode<Integer> nHead = new ListNode<Integer>(val, head);
      head = nHead;
    }

    public int pop() {
      if (empty()) {
        throw new EmptyStackException();
      }
      int curHeadData = head.data;
      head = head.next;
      if (curHeadData == min()) {
        mins.pop();
      }
      return curHeadData;
    }

    public int min() {
      if (empty()) {
        return Integer.MAX_VALUE;
      }
      return mins.peek();
    }

    public boolean empty() {
      return head == null;
    }
  }

  @EpiUserType(ctorParams = { String.class, int.class })
  public static class StackOp {
    public String op;
    public int val;

    public StackOp(String op, int val) {
      this.op = op;
      this.val = val;
    }
  }

  @EpiTest(testDataFile = "../test_data/ctci/stack_min.tsv")
  public static void stackMinTest(List<StackOp> ops) throws TestFailure {
    try {
      StackWithMin s = new StackWithMin();
      int result;
      for (StackOp op : ops) {
        switch (op.op) {
          case "push":
            s.push(op.val);
            break;
          case "pop":
            result = s.pop();
            if (result != op.val) {
              throw new TestFailure("Pop: expected " + String.valueOf(op.val) + ", got " + String.valueOf(result));
            }
            break;
          case "empty":
            result = s.empty() ? 1 : 0;
            if (result != op.val) {
              throw new TestFailure("Empty: expected " + String.valueOf(op.val) + ", got " + String.valueOf(s));
            }
            break;
          case "min":
            result = s.min();
            if (result != op.val) {
              throw new TestFailure("Max: expected " + String.valueOf(op.val) +
                                    ", got " + String.valueOf(result));
            }
            break;
          case "StackMin":
            break;
          default:
            throw new RuntimeException("Unsupported stack operation: " + op.op);
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "StackMin.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
