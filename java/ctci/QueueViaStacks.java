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
    - Must implement a LIFO ordered collection using two FIFO ordered collections.
*/

public class QueueViaStacks {
  public static class Queue {
    Stack<Integer> fifo;
    Stack<Integer> lifo;

    public Queue() {
      fifo = new Stack<Integer>();
      lifo = new Stack<Integer>();
    }

    public void push(int val) {
      fifo.push(val);
    }

    public int pop() {
      if (lifo.empty()) {
        while (!fifo.empty()) {
          lifo.push(fifo.pop());
        }
      }

      if (lifo.empty()) {
        throw new RuntimeException();
      }

      return lifo.pop();
    }

    public boolean empty() {
      return fifo.empty() && lifo.empty();
    }
  }

  @EpiUserType(ctorParams = { String.class, int.class })
  public static class QueueOp {
    public String op;
    public int val;

    public QueueOp(String op, int val) {
      this.op = op;
      this.val = val;
    }
  }

  @EpiTest(testDataFile = "../test_data/ctci/queue_via_stacks.tsv")
  public static void setOfStacksTest(List<QueueOp> ops) throws TestFailure {
    try {
      Queue s = new Queue();
      int result;
      for (QueueOp op : ops) {
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
          case "QueueViaStacks":
            break;
          default:
            throw new RuntimeException("Unsupported queue operation: " + op.op);
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "QueueViaStacks.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
