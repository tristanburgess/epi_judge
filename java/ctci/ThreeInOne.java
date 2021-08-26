package ctci;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import test_framework.TestFailure;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

/*  MY ANSWERS:

    Requirements
    ------------
    - There are no limitations on how we arrange the three stack's memory in the array. As long as we
    maintain LIFO semantics elements can grow in any direction, ordering etc.
    - Every instantiation of a three stack sets up the ability to manage exactly three stacks.
    - Insertion and deletion requirements are random and not necessarily evenly distributed amongst the three stacks.

    Solution: O(1) time for empty, peek, pop, push
    --------
    Break up array into 3 semgents. 
    First stack starts at beginning of array and grows to the right.
    Second stack starts at 1/3 of array and grows to the right.
    Third stack starts 2/3 of array and grows to the right.

    Solution: won't implement, but we could allow dynamic capacity per stack.
*/

public class ThreeInOne {
  public static class ThreeStack {
    private final int NUM_STACKS = 3;
    private int capacityPerStack;
    private int[] headIndexes;
    private int[] vals;

    public ThreeStack(int capacityPerStack) {
      this.capacityPerStack = capacityPerStack;
      headIndexes = new int[NUM_STACKS];
      for (int i = 0; i < NUM_STACKS; i++) {
        headIndexes[i] = i * capacityPerStack;
      }
      vals = new int[capacityPerStack * NUM_STACKS];
    }

    public boolean empty(int stackIdx) {
      return headIndexes[stackIdx] == stackIdx * capacityPerStack;
    }

    public boolean full(int stackIdx) {
      return headIndexes[stackIdx] >= (stackIdx + 1) * capacityPerStack;
    }

    public int peek(int stackIdx) {
      return vals[headIndexes[stackIdx] - 1];
    }

    public int pop(int stackIdx) {
      if (empty(stackIdx)) {
        throw new EmptyStackException();
      }

      int val = vals[headIndexes[stackIdx] - 1];
      headIndexes[stackIdx]--;
      return val;
    }

    public void push(int stackIdx, int val) {
      if (full(stackIdx)) {
        throw new RuntimeException(String.format("Stack at index %d was full.", stackIdx));
      }

      vals[headIndexes[stackIdx]] = val;
      headIndexes[stackIdx]++;
    }
  }

  @EpiUserType(ctorParams = { String.class, int.class, int.class })
  public static class ThreeStackOp {
    public String op;
    public int stackIdx;
    public int val;

    public ThreeStackOp(String op, int stackIdx, int val) {
      this.op = op;
      this.stackIdx = stackIdx;
      this.val = val;
    }
  }

  @EpiTest(testDataFile = "../test_data/ctci/three_in_one.tsv")
  public static void threeStackTest(List<ThreeStackOp> ops) throws TestFailure {
    try {
      ThreeStack s = new ThreeStack(ops.get(0).val);
      int result;
      for (ThreeStackOp op : ops) {
        switch (op.op) {
          case "push":
            s.push(op.stackIdx, op.val);
            break;
          case "pop":
            result = s.pop(op.stackIdx);
            if (result != op.val) {
              throw new TestFailure("Pop: expected " + String.valueOf(op.val) + ", got " + String.valueOf(result));
            }
            break;
          case "full":
            result = s.full(op.stackIdx) ? 1 : 0;
            if (result != op.val) {
              throw new TestFailure("Full: expected " + String.valueOf(op.val) + ", got " + String.valueOf(s));
            }
            break;
          case "empty":
            result = s.empty(op.stackIdx) ? 1 : 0;
            if (result != op.val) {
              throw new TestFailure("Empty: expected " + String.valueOf(op.val) + ", got " + String.valueOf(s));
            }
            break;
          case "ThreeStack":
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
    System.exit(GenericTest.runFromAnnotations(args, "ThreeInOne.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
