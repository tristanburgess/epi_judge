package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class LongestSubarrayWithSumConstraint {
  @EpiTest(testDataFile = "../test_data/epi/longest_subarray_with_sum_constraint.tsv")

  public static int findLongestSubarrayLessEqualK(List<Integer> A, int k) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestSubarrayWithSumConstraint.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
