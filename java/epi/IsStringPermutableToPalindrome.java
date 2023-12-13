package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsStringPermutableToPalindrome {

  @EpiTest(testDataFile = "../test_data/epi/is_string_permutable_to_palindrome.tsv")
  public static boolean canFormPalindrome(String s) {
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPermutableToPalindrome.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
