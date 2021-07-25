package ctci;

import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Only uppercase and lowercase letters
    - Case sensitive

    Can't do better than O(n) time because we need to look at each character
    to know how many of each there are.

    We can build two kind of solutions, both are similar except the latter trades a bit
    of time for memory in the case that compression wouldn't actually help:

    1) Build the candidate compressed string, if the resulting length is shorter return it,
    else return the original string.
    2) Check what the length of the compressed string would be (basically the same loop just without
    the StringBuilder parts). Exit early if the original string would be shorter, else go ahead and
    build the compressed string and then return it.

    Also note that using StringBuilder is much more efficent than concatenating strings, which makes a new
    string large enough to hold both strings to use in the concatenation, and then copies each string over to the
    larger string. If we have a loop over n strings, each string being concatenated to an accumulative string, then
    the total time is O(xn^2) where x is the number of characters per string (assume a constant/max is chosen.

    StringBuilders instead maintains a resizable array of all the strings. The final string is only built up when desired.
*/

public class StringCompression {
    @EpiTest(testDataFile = "../test_data/ctci/string_compression.tsv")
    public static String compress(String s) {
        if (s.length() == 0) {
            return s;
        }

        StringBuilder candidate = new StringBuilder();
        char lastSeen = s.charAt(0);
        int countLastSeen = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == lastSeen) {
                countLastSeen++;
            } else {
                candidate.append(lastSeen);
                candidate.append(countLastSeen);
                lastSeen = cur;
                countLastSeen = 1;
            }
        }
        candidate.append(lastSeen);
        candidate.append(countLastSeen);

        if (candidate.length() < s.length()) {
            return candidate.toString();
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.exit(GenericTest.runFromAnnotations(args, "StringCompression.java", new Object() {
        }.getClass().getEnclosingClass()).ordinal());
    }
}
