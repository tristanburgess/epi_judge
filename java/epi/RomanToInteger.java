package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class RomanToInteger {
  @EpiTest(testDataFile = "../test_data/epi/roman_to_integer.tsv")

  public static int romanToInteger(String s) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RomanToInteger.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
