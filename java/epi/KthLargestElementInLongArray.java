package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
import java.util.Iterator;

public class KthLargestElementInLongArray {

  public static int findKthLargestUnknownLength(Iterator<Integer> stream,
      int k) {
    // TODO - you fill in here.
    return 0;
  }

  @EpiTest(testDataFile = "../test_data/epi/kth_largest_element_in_long_array.tsv")
  public static int findKthLargestUnknownLengthWrapper(List<Integer> stream,
      int k) {
    return findKthLargestUnknownLength(stream.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KthLargestElementInLongArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
