package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsStringPermutableToPalindrome {

  @EpiTest(testDataFile = "../test_data/epi/is_string_permutable_to_palindrome.tsv")
  public static boolean canFormPalindrome(String s) {
    int[] freq = new int[128];

    for (char c : s.toCharArray()) {
      freq[c]++;
    }

    int numOdds = 0;
    for (int f : freq) {
      if (f % 2 != 0 && ++numOdds > 1) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPermutableToPalindrome.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
