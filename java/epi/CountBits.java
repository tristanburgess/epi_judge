package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class CountBits {

  @EpiTest(testDataFile = "../test_data/epi/count_bits.tsv")
  public static short countBits(int x) {
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CountBits.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
