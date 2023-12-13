package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class SortedListsMerge {

  @EpiTest(testDataFile = "../test_data/epi/sorted_lists_merge.tsv")
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
      ListNode<Integer> L2) {
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
