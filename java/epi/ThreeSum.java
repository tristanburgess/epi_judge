package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class ThreeSum {
  @EpiTest(testDataFile = "../test_data/epi/three_sum.tsv")

  public static boolean hasThreeSum(List<Integer> A, int t) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ThreeSum.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
