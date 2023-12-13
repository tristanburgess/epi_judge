package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class LevenshteinDistance {
  @EpiTest(testDataFile = "../test_data/epi/levenshtein_distance.tsv")

  public static int levenshteinDistance(String A, String B) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LevenshteinDistance.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
