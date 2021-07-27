package ctci;

import test_framework.EpiTest;
import test_framework.GenericTest;

/*  
MY ANSWERS:

Requirements
------------
  - Assume case sensitive
  - Must use exactly one call to isSubstring.

e.g. waterbottle is a rotation of erbottlewat.

First, we know that if both strings have different lengths they cannot be rotations
of each other.

Otherwise, for t to be a rotation of s there must exist some pivot point which divides
t into two parts, where if the ordering of the parts were reversed, the resulting string would
equal s.

erbottlewat => erbottle wat => wat erbottle => waterbottle

We observer that wat erbottle does have both of the same parts, just in the wrong order.
To include the reverse order, we can simply concatenate s with itself:
waterbottle => waterbottlewaterbottle => wat erbottle wat erbottle.
We see now in the middle the reverse order parts are there.
So isSubstring(t, s + s) should suffice to confirm both parts are present in t.

Time + space complexity depends on the implementation of the substring checker.
A KMP implementation may take O(n) where n is the length of both strings, assuming they're of the same length,
because otherwise our algorithm terminates early.

*/

public class StringRotation {
    @EpiTest(testDataFile = "../test_data/ctci/string_rotation.tsv")
    public static boolean stringRotation(String s, String t) {
        if (s.length() != t.length() || s.length() == 0 || t.length() == 0) {
            return false;
        }

        return (s + s).contains(t);
    }

    public static void main(String[] args) {
        System.exit(GenericTest.runFromAnnotations(args, "StringRotation.java", new Object() {
        }.getClass().getEnclosingClass()).ordinal());
    }
}
