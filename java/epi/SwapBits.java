package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class SwapBits {

  @EpiTest(testDataFile = "../test_data/epi/swap_bits.tsv")
  public static long swapBits(long x, int i, int j) {
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SwapBits.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
