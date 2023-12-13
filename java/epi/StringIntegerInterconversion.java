package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TestFailure;

public class StringIntegerInterconversion {

  public static String intToString(int x) {
    return "";
  }

  public static int stringToInt(String s) {
    return 0;
  }

  @EpiTest(testDataFile = "../test_data/epi/string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (!intToString(x).equals(s)) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
