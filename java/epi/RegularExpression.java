package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class RegularExpression {
  @EpiTest(testDataFile = "../test_data/epi/regular_expression.tsv")

  public static boolean isMatch(String regex, String s) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RegularExpression.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
