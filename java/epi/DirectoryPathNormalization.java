package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class DirectoryPathNormalization {
  @EpiTest(testDataFile = "../test_data/epi/directory_path_normalization.tsv")

  public static String shortestEquivalentPath(String path) {
    // TODO - you fill in here.
    return "";
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DirectoryPathNormalization.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
