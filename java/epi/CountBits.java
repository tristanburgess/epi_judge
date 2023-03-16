package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class CountBits {

  @EpiTest(testDataFile = "../test_data/epi/count_bits.tsv")
  public static short countBits(int x) {
    short c = 0;

    while (x != 0) {
      ++c;
      x &= (x - 1);
    }

    return c;
  }

  @EpiTest(testDataFile = "../test_data/epi/count_bits.tsv")
  public static short countBitsCached(int x) {
    short[] a = new short[256];
    for (short i = 0; i < 256; i++) {
      a[i] = countBits(i);
    }

    return (short) (
            a[(x >> 24) & 0xFF] +
            a[(x >> 16) & 0xFF] +
            a[(x >> 8) & 0xFF] +
            a[x & 0xFF]
    );
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CountBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
