package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class NumberOfTraversalsStaircase {
  @EpiTest(testDataFile = "../test_data/epi/number_of_traversals_staircase.tsv")

  public static int numberOfWaysToTop(int top, int maximumStep) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NumberOfTraversalsStaircase.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
