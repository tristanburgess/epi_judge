package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class PrimitiveDivide {
  @EpiTest(testDataFile = "../test_data/epi/primitive_divide.tsv")
  public static int divide(int x, int y) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveDivide.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
