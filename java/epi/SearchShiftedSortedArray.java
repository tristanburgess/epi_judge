package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class SearchShiftedSortedArray {
  @EpiTest(testDataFile = "../test_data/epi/search_shifted_sorted_array.tsv")

  public static int searchSmallest(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchShiftedSortedArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
