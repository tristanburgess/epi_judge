package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class NearestRepeatedEntries {
  @EpiTest(testDataFile = "../test_data/epi/nearest_repeated_entries.tsv")

  public static int findNearestRepetition(List<String> paragraph) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NearestRepeatedEntries.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
