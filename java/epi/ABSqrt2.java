package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class ABSqrt2 {
  @EpiTest(testDataFile = "../test_data/epi/a_b_sqrt2.tsv")

  public static List<Double> generateFirstKABSqrt2(int k) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ABSqrt2.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
