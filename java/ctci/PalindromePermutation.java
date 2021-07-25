package ctci;

import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Input characters are only recognized if they're alphabetical.
      All other characters are ignored.
    - Input characters are treated case insensitive.
    - Output is a boolean, whether or not the input string is a palindrome permutation.

    Solution: O(k) time O(1) space, k is length of the input string. 
    We can't improve on this, because we have to look at each character in the string.
    --------
    There are two cases for palindromes. One is that the string length is even e.g. boxxob
    in which case all character counts are even. The other is that the string length is odd e.g. boxob
    in which case all character counts are even except for one character which may have an odd count.

    Loop over all characters in s and build a case-insensitive frequency map of just lowercase 
    alphabetic letters to counts. Ignore all other characters.

    If we have no odd frequencies then that satisfies the first case.
    If we have only one odd frequency then that satisfies the second case.
*/

public class PalindromePermutation {
  // Takes advantage of the fact that we only have 26 chars
  // and only need to know if each char has an even or odd count.
  // Thus can represent as a single 32-bit int bit mask.
  @EpiTest(testDataFile = "../test_data/ctci/palindrome_permutation.tsv")
  public static boolean palindromePermutationBitVec(String s) {
    int alphaFreq = 0x0;
    boolean alphaFound = false;

    for (char c : s.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        c = (char) ('a' + (c - 'A'));
      }
      if (c >= 'a' && c <= 'z') {
        alphaFreq ^= 0x1 << (c - 'a');
        alphaFound = true;
      }
    }

    return alphaFound && (alphaFreq & (alphaFreq - 1)) == 0;
  }

  @EpiTest(testDataFile = "../test_data/ctci/palindrome_permutation.tsv")
  public static boolean palindromePermutation(String s) {
    final int ALPHA_COUNT = 26;
    int[] alphaFreq = new int[ALPHA_COUNT];
    boolean alphaFound = false;

    for (char c : s.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        c = (char) ('a' + (c - 'A'));
      }
      if (c >= 'a' && c <= 'z') {
        alphaFreq[c - 'a']++;
        alphaFound = true;
      }
    }

    if (!alphaFound) {
      return false;
    }

    boolean oddFreqFound = false;
    for (int i = 0; i < ALPHA_COUNT; i++) {
      if (alphaFreq[i] % 2 == 1) {
        if (oddFreqFound) {
          return false;
        }
        oddFreqFound = true;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "PalindromePermutation.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
