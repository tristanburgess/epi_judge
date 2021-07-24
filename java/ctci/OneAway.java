package ctci;

import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Assume any extended ASCII character is allowed
    - Assume case sensitivity holds

    Likely can't take any less time than O(s + t) where s is the length of the
    first string and t is the length of the second, because you have to know about
    each character to compare between the two strings.

    The three cases

    One edit
    --------
    A single character is mismatched between the two strings.
    This must mean that both strings have the same lengths.

    One insert
    ----------
    One of the strings is longer than the other by one character.
    The first character mismatch found can be ignored, provided the rest of the characters
    between the two strings match. This means some character in the longer string must not be in the
    shorter string and should be skipped over, but if another mismatch is found that would require more
    than one edit/insert.

    One removal
    -----------
    Pretty much the same behavior as insertion, since removal is the inverse of insertion.

    Ad Hoc: O(n) time O(1) space, where n is the length of the smaller string.
    Length of the smaller string because if one of the strings is more than one character longer
    than the other, the algorithm will terminate early O(1) time.
*/

public class OneAway {
  @EpiTest(testDataFile = "../test_data/ctci/one_away.tsv")
  public static boolean oneAway(String s, String t) {
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }

    String sm = s.length() > t.length() ? t : s;
    String lg = s.length() > t.length() ? s : t;
 
    boolean edit = false;
    int i = 0;
    int j = 0;

    while (i < sm.length() && j < lg.length()) {
      if (sm.charAt(i) != lg.charAt(j)) {
        if (edit) {
          return false;
        }
        edit = true;
        if (sm.length() == lg.length()) {
          i++;
        }
      } else {
        i++;
      }

      j++;
    }
  
    return true;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "OneAway.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
