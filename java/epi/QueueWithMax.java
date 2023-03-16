package epi;
import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import test_framework.TestFailure;

import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;

// Naive bootcamp impl
public class QueueWithMax {
  private Deque<Integer> dq;

  public QueueWithMax() {
    dq = new LinkedList<Integer>();
  }

  public void enqueue(Integer x) {
    dq.addLast(x);
  }

  public Integer dequeue() throws NoSuchElementException {
    return dq.removeFirst();
  }

  public Integer max() throws NoSuchElementException {
    return Collections.max(dq);
  }

  @EpiUserType(ctorParams = {String.class, int.class})
  public static class QueueOp {
    public String op;
    public int arg;

    public QueueOp(String op, int arg) {
      this.op = op;
      this.arg = arg;
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/queue_with_max.tsv")
  public static void queueTest(List<QueueOp> ops) throws TestFailure {
    try {
      QueueWithMax q = new QueueWithMax();

      for (QueueOp op : ops) {
        switch (op.op) {
        case "QueueWithMax":
          q = new QueueWithMax();
          break;
        case "enqueue":
          q.enqueue(op.arg);
          break;
        case "dequeue":
          int result = q.dequeue();
          if (result != op.arg) {
            throw new TestFailure("Dequeue: expected " +
                                  String.valueOf(op.arg) + ", got " +
                                  String.valueOf(result));
          }
          break;
        case "max":
          int s = q.max();
          if (s != op.arg) {
            throw new TestFailure("Max: expected " + String.valueOf(op.arg) +
                                  ", got " + String.valueOf(s));
          }
          break;
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "QueueWithMax.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
