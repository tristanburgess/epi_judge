package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class LongestContainedInterval {
  @EpiTest(testDataFile = "../test_data/epi/longest_contained_interval.tsv")

  public static int longestContainedRange(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LongestContainedInterval.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
