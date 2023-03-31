package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class ConvertBase {

  @EpiTest(testDataFile = "../test_data/epi/convert_base.tsv")
  public static String convertBase(String numAsString, int b1, int b2) {
    int acc = 0;
    int fac = 1;
    boolean neg = numAsString.charAt(0) == '-';
    int begin = neg ? 1 : 0;
    StringBuilder out = new StringBuilder();
    
    for (int i = numAsString.length() - 1; i >= begin; i--) {
      int d1 = numAsString.charAt(i) - '0';
      if (d1 > 9) {
        d1 = (numAsString.charAt(i) - 'A') + 10;
      }
      acc += d1 * fac;
      fac *= b1;
    }

    do {
      int d2 = acc % b2;
      if (d2 > 9) {
        out.append((char)((d2 - 10) + 'A'));
      } else {
        out.append(d2);
      }

      acc /= b2;
    } while (acc != 0);

    if (neg) {
      out.append('-');
    }
  
    return out.reverse().toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
