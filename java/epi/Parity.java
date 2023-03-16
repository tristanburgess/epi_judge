package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class Parity {

  @EpiTest(testDataFile = "../test_data/epi/parity.tsv")
  public static short parity(long x) {
    short p = 0;

    while (x != 0) {
      x &= (x - 1);
      p ^= 1;
    }

    return p;
  }

  @EpiTest(testDataFile = "../test_data/epi/parity.tsv")
  public static short parityDC(long x) {
    x ^= (x >>> 32);
    x ^= (x >>> 16);
    x ^= (x >>> 8);
    x ^= (x >>> 4);
    x ^= (x >>> 2);
    x ^= (x >>> 1);
    return (short)(x & 0x1);
  }

  @EpiTest(testDataFile = "../test_data/epi/parity.tsv")
  public static short parityTable(long x) {
    short[] pt = new short[65536];
    for (int i = 0; i < 65536; i++) {
      pt[i] = parity(i);
    }

    return (short) (
      pt[(int)(x >>> 48)] ^
      pt[(int)((x >>> 32) & 0xFFFF)] ^
      pt[(int)((x >>> 16) & 0xFFFF)] ^
      pt[(int)(x & 0xFFFF)]
    );
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Parity.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
