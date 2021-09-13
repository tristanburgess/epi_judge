package ctci;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import test_framework.TestFailure;

import java.util.NoSuchElementException;
import java.util.Stack;

// Whiteboard: https://1drv.ms/u/s!AvHgsMnKfyusiIE2HJFqP0Yhx0To7g

public class SortStack {
  public static class StackWithSort {
    Stack<Integer> primaryStack;

    public StackWithSort() {
      primaryStack = new Stack<Integer>();
    }

    public void push(int val) {
      primaryStack.push(val);
    }

    public int peek() {
      return primaryStack.peek();
    }

    public int pop() {
      return primaryStack.pop();
    }

    public boolean empty() {
      return primaryStack.empty();
    }

    public void sort() {
      Stack<Integer> bufStack = new Stack<Integer>();

      while (!primaryStack.empty()) {
        int tmp = primaryStack.pop();
        while (!bufStack.empty() && bufStack.peek() > tmp) {
          primaryStack.push(bufStack.pop());
        }
        bufStack.push(tmp);
      }

      while (!bufStack.empty()) {
        primaryStack.push(bufStack.pop());
      }
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

  @EpiTest(testDataFile = "../test_data/ctci/sort_stack.tsv")
  public static void sortStackTest(List<StackOp> ops) throws TestFailure {
    try {
      StackWithSort s = new StackWithSort();
      int res;
      for (StackOp op : ops) {
        switch (op.op) {
          case "push":
            s.push(op.val);
            break;
          case "peek":
            res = s.peek();
            if (res != op.val) {
              throw new TestFailure("Peek: expected " + String.valueOf(op.val) + ", got " + String.valueOf(res));
            }
            break;
          case "pop":
            res = s.pop();
            if (res != op.val) {
              throw new TestFailure("Pop: expected " + String.valueOf(op.val) + ", got " + String.valueOf(res));
            }
            break;
          case "empty":
            res = s.empty() ? 1 : 0;
            if (res != op.val) {
              throw new TestFailure("Empty: expected " + String.valueOf(op.val) + ", got " + String.valueOf(s));
            }
            break;
          case "sort":
            s.sort();
            int prev = op.val;
            res = s.peek();
            if (res != prev) {
              throw new TestFailure("Sort: expected " + String.valueOf(prev) + ", got " + String.valueOf(res));
            }
            s.pop();
            while (!s.empty()) {
              res = s.pop();
              if (res < prev) {
                throw new TestFailure("Sort: expected next " + String.valueOf(res)
                    + " to be greater than or equal to prev " + String.valueOf(prev) + ", but was less");
              }
              prev = res;
            }
            break;
          case "Stack":
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
    System.exit(GenericTest.runFromAnnotations(args, "SortStack.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
