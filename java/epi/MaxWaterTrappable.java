package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MaxWaterTrappable {
  @EpiTest(testDataFile = "../test_data/epi/max_water_trappable.tsv")

  public static int calculateTrappingWater(List<Integer> heights) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaxWaterTrappable.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
