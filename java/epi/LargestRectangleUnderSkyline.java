package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class LargestRectangleUnderSkyline {
  @EpiTest(testDataFile = "../test_data/epi/largest_rectangle_under_skyline.tsv")

  public static int calculateLargestRectangle(List<Integer> heights) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LargestRectangleUnderSkyline.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
