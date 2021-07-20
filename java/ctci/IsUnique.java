package ctci;

import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.Arrays;

/*  
MY ANSWERS:

Requirements
------------
Assume only extended ASCII characters, 256 possible characters.
Assume case-sensitive, so that 'a' != 'A'
Given a string "abcdefga"

Let k be the number of characters in the string

First, ensure the string is not longer than 256 characters,
else there is no possible way all of them are unique, so return false
in that case.

Brute force: O(k^2) time O(1) space
-----------------------------------
for each character
    loop over all other characters in the string
    if a match is found, return false
return true

Sort string: O(klogk) time O(k) space
-------------------------------------
create a new string containing sorted string
initialize last character seen to ''
for each character
    if current is equal to last character seen return false
    set last character seen to current
return true

Occurrence map: O(k) time O(1) space
-----------------------------------
build an integer array which can map to all 256 possible ASCII codes.
for each character
    loop up ASCII code in occurrence map
    if occurence exists return false
    else set occurence to true
return true
*/

public class IsUnique {

  @EpiTest(testDataFile = "../test_data/ctci/is_unique.tsv")
  public static boolean isUnique(String str) {
    final int FREQ_LEN = 256;

    if (str.length() > FREQ_LEN) {
      return false;
    }

    boolean[] set = new boolean[FREQ_LEN];

    for (int i = 0; i < str.length(); i++) {
      int cur = str.charAt(i);
      if (set[cur]) {
        return false;
      }
      set[cur] = true;
    }

    return true;
  }

  @EpiTest(testDataFile = "../test_data/ctci/is_unique.tsv")
  public static boolean isUniqueBF(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = 0; j < str.length(); j++) {
        if (i != j && str.charAt(i) == str.charAt(j)) {
          return false;
        }
      }
    }

    return true;
  }

  @EpiTest(testDataFile = "../test_data/ctci/is_unique.tsv")
  public static boolean isUniqueSrt(String str) {
    char[] arr = str.toCharArray();
    Arrays.sort(arr);

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "IsUnique.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
