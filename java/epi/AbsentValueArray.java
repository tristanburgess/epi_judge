package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class AbsentValueArray {

  @EpiTest(testDataFile = "../test_data/epi/absent_value_array.tsv")
  public static int findMissingElement(Iterable<Integer> stream) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "AbsentValueArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
