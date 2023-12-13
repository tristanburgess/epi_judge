package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class ReverseBits {

  @EpiTest(testDataFile = "../test_data/epi/reverse_bits.tsv")
  public static long reverseBits(long x) {
    return 0;
  }
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseBits.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
