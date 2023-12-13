package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class RealSquareRoot {
  @EpiTest(testDataFile = "../test_data/epi/real_square_root.tsv")

  public static double squareRoot(double x) {
    // TODO - you fill in here.
    return 0.0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RealSquareRoot.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
