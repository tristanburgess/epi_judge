package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class IntAsListAdd {
  @EpiTest(testDataFile = "../test_data/epi/int_as_list_add.tsv")

  public static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1,
      ListNode<Integer> L2) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsListAdd.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
