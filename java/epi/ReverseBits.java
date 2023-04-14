package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class ReverseBits {

  private static long reverseBitsW(long x, int w) {
    int hi = w - 1;
    int lo = 0;

    while (hi > lo) {
      if (((x >>> hi) & 0x1) != ((x >>> lo) & 0x1)) {
        x ^= (0x1L << hi) | (0x1L << lo);
      }
      hi--;
      lo++;
    }

    return x;
  }

  @EpiTest(testDataFile = "../test_data/epi/reverse_bits.tsv")
  public static long reverseBits(long x) {
    return reverseBitsW(x, 64);
  }

  @EpiTest(testDataFile = "../test_data/epi/reverse_bits.tsv")
  public static long reverseBitsCache(long x) {
    long[] c = new long[65536];
    for (int i = 0; i < 65536; i++) {
      c[i] = reverseBitsW(i, 16);
    }

    long y = c[(int)(x & 0xFFFF)] << 48;
    y |= c[(int)((x >>> 16) & 0xFFFF)] << 32;
    y |= c[(int)((x >>> 32) & 0xFFFF)] << 16;
    y |= c[(int)((x >>> 48) & 0xFFFF)];
    return y;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
