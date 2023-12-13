package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class CollatzChecker {
  @EpiTest(testDataFile = "../test_data/epi/collatz_checker.tsv")

  public static boolean testCollatzConjecture(int n) {
    // TODO - you fill in here.
    return false;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CollatzChecker.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
