package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
public class IsStringPalindromic {
  @EpiTest(testDataFile = "../test_data/epi/is_string_palindromic.tsv")

  public static boolean isPalindromic(String s) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPalindromic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
