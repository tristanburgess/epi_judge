package ctci;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import test_framework.TestFailure;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/*  MY ANSWERS:

    Requirements
    ------------
      - O(1) time for push and pop operations
      - No limit to number of stacks, but each stack must have the same fixed capacity set at initialization

    Solution: O(1) time for each operation
      - Keep an array list of stacks. Push and pop keep track of capacity state of last stack to determine if
      a new stack is needed or the last stack can be removed. The head must be updated to point to the last element
      of the current last stack.
*/

public class StackOfPlates {
  public static class SetOfStacks {
    int capacityPerStack;
    ArrayList<Stack<Integer>> stacks;

    public SetOfStacks(int capacityPerStack) {
      this.capacityPerStack = capacityPerStack;
      stacks = new ArrayList<Stack<Integer>>();
    }

    public void push(int val) {
        if (stacks.size() == 0 || stacks.get(stacks.size() - 1).size() == capacityPerStack) {
          stacks.add(new Stack<Integer>());
        }

        stacks.get(stacks.size() - 1).push(val);
    }

    public int pop() {
      if (stacks.size() == 0) {
        throw new EmptyStackException();
      }

      int val = stacks.get(stacks.size() - 1).pop();
      if (stacks.get(stacks.size() - 1).empty()) {
        stacks.remove(stacks.size() - 1);
      }

      return val;
    }

    public boolean empty() {
      return stacks.size() == 0;
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

  @EpiTest(testDataFile = "../test_data/ctci/stack_of_plates.tsv")
  public static void setOfStacksTest(List<StackOp> ops) throws TestFailure {
    try {
      SetOfStacks s = new SetOfStacks(ops.get(0).val);
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
          case "SetOfStacks":
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
    System.exit(GenericTest.runFromAnnotations(args, "StackOfPlates.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
