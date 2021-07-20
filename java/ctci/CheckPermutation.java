package ctci;

import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.Arrays;

/*  
MY ANSWERS:

Requirements
------------
  - Is whitespace relevant?
  - Is case sensitivity relevant?
  - What is the character set?

Assume first two are relevant, assume extended ASCII.

Two strings can only be a permutation of each other if
they are of equal length.

Freq Map: O(max(x, y)) time O(x + y) space
-------------------------------------------
Note that if not a permutation and lengths are equal, then there must be some letter
in s that is not in t the same number of times, and vice versa.
If all letters in s were in t the same number of times, then the only way s and t are
not permutations is if t contains at least one additional letter than s, which makes
their lengths unequal.

Initialize freq map to int array size 256
For each char in s
  increment the freq map value at the current char index
For each char in t
  decrement the freq map value at the current char index
  if val less than zero, not a permutation

Sort: O(xlogx + ylogy) time and O(x + y) space
----------------------------------------------
Sort s and t
For each character in s, if char at current index in t is not the same, not a permutation
*/

public class CheckPermutation {
  private static String sort(String s) {
    char[] sArr = s.toCharArray();
    Arrays.sort(sArr);
    return new String(sArr);
  }

  @EpiTest(testDataFile = "../test_data/ctci/check_permutation.tsv")
  public static boolean checkPermutationSort(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    return sort(s).equals(sort(t));
  }

  @EpiTest(testDataFile = "../test_data/ctci/check_permutation.tsv")
  public static boolean checkPermutation(String s, String t) {
    final int FREQ_LEN = 256;

    if (s.length() != t.length()) {
      return false;
    }

    int[] freq = new int[FREQ_LEN];

    for (char x : s.toCharArray()) {
      freq[(int) x]++;
    }

    for (char x : t.toCharArray()) {
      freq[(int) x]--;
      if (freq[x] < 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "CheckPermutation.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
