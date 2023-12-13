package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class SearchUnknownLengthArray {
  @EpiTest(testDataFile = "../test_data/epi/search_unknown_length_array.tsv")

  public static int binarySearchUnknownLength(List<Integer> A, int k) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchUnknownLengthArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
