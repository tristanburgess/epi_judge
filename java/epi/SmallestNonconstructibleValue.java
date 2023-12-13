package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class SmallestNonconstructibleValue {
  @EpiTest(testDataFile = "../test_data/epi/smallest_nonconstructible_value.tsv")

  public static int smallestNonconstructibleValue(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SmallestNonconstructibleValue.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
