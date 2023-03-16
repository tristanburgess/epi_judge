package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TestFailure;

public class StringIntegerInterconversion {

  public static String intToString(int x) {
    StringBuilder s = new StringBuilder();
    boolean sign = x < 0;

    do {
      s.append((char)(Math.abs(x % 10) + '0'));
      x /= 10;
    } while (x != 0);

    if (sign) {
      s.append('-');
    }
  
    return s.reverse().toString();
  }

  public static int stringToInt(String s) {
    if (s.length() == 0) {
      throw new IllegalArgumentException("Can't parse an empty string to an int.");
    }

    int x = 0;
    for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++) {
      x = x * 10 + (int)(s.charAt(i) - '0');
    }
    return s.charAt(0) == '-' ? -x : x;
  }

  @EpiTest(testDataFile = "../test_data/epi/string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (!intToString(x).equals(s)) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
