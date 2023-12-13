package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class SnakeString {
  @EpiTest(testDataFile = "../test_data/epi/snake_string.tsv")

  public static String snakeString(String s) {
    // TODO - you fill in here.
    return "";
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SnakeString.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
