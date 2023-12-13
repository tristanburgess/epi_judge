package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class Parity {

  @EpiTest(testDataFile = "../test_data/epi/parity.tsv")
  public static short parity(long x) {
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Parity.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
