package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class IsStringInMatrix {
  @EpiTest(testDataFile = "../test_data/epi/is_string_in_matrix.tsv")
  public static boolean isPatternContainedInGrid(List<List<Integer>> grid,
      List<Integer> pattern) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringInMatrix.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
