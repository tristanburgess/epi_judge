package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class LongestSubarrayWithDistinctValues {
  @EpiTest(testDataFile = "../test_data/epi/longest_subarray_with_distinct_values.tsv")

  public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestSubarrayWithDistinctValues.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
