package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
public class ReverseDigits {
  @EpiTest(testDataFile = "../test_data/epi/reverse_digits.tsv")
  public static long reverse(int x) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseDigits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
