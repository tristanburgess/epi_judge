package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class Gcd {
  @EpiTest(testDataFile = "../test_data/epi/gcd.tsv")

  public static long GCD(long x, long y) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Gcd.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
