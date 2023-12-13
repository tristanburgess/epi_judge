package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class BinomialCoefficients {
  @EpiTest(testDataFile = "../test_data/epi/binomial_coefficients.tsv")

  public static int computeBinomialCoefficient(int n, int k) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BinomialCoefficients.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
