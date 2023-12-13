package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsNumberPalindromic {
  @EpiTest(testDataFile = "../test_data/epi/is_number_palindromic.tsv")
  public static boolean isPalindromeNumber(int x) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsNumberPalindromic.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
