package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MaxSubmatrix {

  @EpiTest(testDataFile = "../test_data/epi/max_submatrix.tsv")

  public static int maxRectangleSubmatrix(List<List<Boolean>> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaxSubmatrix.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
