package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class ReverseSublist {

  @EpiTest(testDataFile = "../test_data/epi/reverse_sublist.tsv")
  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
