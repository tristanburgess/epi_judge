package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class PrimitiveMultiply {
  @EpiTest(testDataFile = "../test_data/epi/primitive_multiply.tsv")
  public static long multiply(long x, long y) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimitiveMultiply.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
