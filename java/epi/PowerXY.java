package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class PowerXY {
  @EpiTest(testDataFile = "../test_data/epi/power_x_y.tsv")
  public static double power(double x, int y) {
    // TODO - you fill in here.
    return 0.0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PowerXY.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
