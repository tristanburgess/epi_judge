package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class CountInversions {
  @EpiTest(testDataFile = "../test_data/epi/count_inversions.tsv")

  public static int countInversions(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CountInversions.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
