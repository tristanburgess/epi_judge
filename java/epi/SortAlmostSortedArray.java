package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.Iterator;
import java.util.List;

public class SortAlmostSortedArray {

  public static List<Integer> sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTest(testDataFile = "../test_data/epi/sort_almost_sorted_array.tsv")
  public static List<Integer> sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
    return sortApproximatelySortedData(sequence.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortAlmostSortedArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
