package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.Set;

public class StringTransformability {

  @EpiTest(testDataFile = "../test_data/epi/string_transformability.tsv")

  // Uses BFS to find the least steps of transformation.
  public static int transformString(Set<String> D, String s, String t) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringTransformability.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
