package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MinimumWeightPathInATriangle {
  @EpiTest(testDataFile = "../test_data/epi/minimum_weight_path_in_a_triangle.tsv")

  public static int minimumPathTotal(List<List<Integer>> triangle) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MinimumWeightPathInATriangle.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
