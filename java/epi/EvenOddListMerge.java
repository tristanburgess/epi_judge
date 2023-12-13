package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class EvenOddListMerge {
  @EpiTest(testDataFile = "../test_data/epi/even_odd_list_merge.tsv")

  public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvenOddListMerge.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
