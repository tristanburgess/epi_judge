package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class MaxSafeHeight {
  @EpiTest(testDataFile = "../test_data/epi/max_safe_height.tsv")

  public static int getHeight(int cases, int drops) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaxSafeHeight.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
