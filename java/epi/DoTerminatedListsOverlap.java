package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TestFailure;
import test_framework.TimedExecutor;

public class DoTerminatedListsOverlap {

  public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTest(testDataFile = "../test_data/epi/do_terminated_lists_overlap.tsv")
  public static void overlappingNoCycleListsWrapper(TimedExecutor executor, ListNode<Integer> l0,
      ListNode<Integer> l1, ListNode<Integer> common)
      throws Exception {
    if (common != null) {
      if (l0 != null) {
        ListNode<Integer> i = l0;
        while (i.next != null) {
          i = i.next;
        }
        i.next = common;
      } else {
        l0 = common;
      }

      if (l1 != null) {
        ListNode<Integer> i = l1;
        while (i.next != null) {
          i = i.next;
        }
        i.next = common;
      } else {
        l1 = common;
      }
    }

    final ListNode<Integer> finalL0 = l0;
    final ListNode<Integer> finalL1 = l1;
    ListNode<Integer> result = executor.run(() -> overlappingNoCycleLists(finalL0, finalL1));

    if (result != common) {
      throw new TestFailure("Invalid result");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DoTerminatedListsOverlap.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
