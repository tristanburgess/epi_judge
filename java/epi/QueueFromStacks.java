package epi;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import test_framework.TestFailure;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueFromStacks {

  public static class Queue {
    public void enqueue(Integer x) {
      // TODO - you fill in here.
      return;
    }

    public Integer dequeue() {
      // TODO - you fill in here.
      return 0;
    }
  }

  @EpiUserType(ctorParams = { String.class, int.class })
  public static class QueueOp {
    public String op;
    public int arg;

    public QueueOp(String op, int arg) {
      this.op = op;
      this.arg = arg;
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/queue_from_stacks.tsv")
  public static void queueTest(List<QueueOp> ops) throws TestFailure {
    try {
      Queue q = new Queue();

      for (QueueOp op : ops) {
        switch (op.op) {
          case "QueueWithMax":
            q = new Queue();
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
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "QueueFromStacks.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
