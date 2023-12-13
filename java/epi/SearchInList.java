package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class SearchInList {

  public static ListNode<Integer> searchList(ListNode<Integer> L, int key) {
    return null;
  }

  @EpiTest(testDataFile = "../test_data/epi/search_in_list.tsv")
  public static int searchListWrapper(ListNode<Integer> L, int key) {
    ListNode<Integer> result = searchList(L, key);
    return result != null ? result.data : -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchInList.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
