package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class LongestNondecreasingSubsequence {
  @EpiTest(testDataFile = "../test_data/epi/longest_nondecreasing_subsequence.tsv")

  public static int longestNondecreasingSubsequenceLength(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestNondecreasingSubsequence.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
