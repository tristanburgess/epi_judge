package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class SwapBits {

  @EpiTest(testDataFile = "../test_data/epi/swap_bits.tsv")
  public static long swapBitsCond(long x, int i, int j) {
    if (((x >>> i) & 0x1) != ((x >>> j) & 0x1)) {
      return x ^ ((0x1L << i) | (0x1L << j));
    }

    return x;
  }

  @EpiTest(testDataFile = "../test_data/epi/swap_bits.tsv")
  public static long swapBits(long x, int i, int j) {
    long xi = (x >>> i) & 0x1;
    long xj = (x >>> j) & 0x1;
    long xij = xi ^ xj;

    return x ^ ((xij << i) | (xij << j));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SwapBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
