package ctci;

import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    Must adjust input string in place (using char array)
    The true string length is provided, can assume we have exactly enough space
    for each space character to be replaced by the three characters %20

    Brute Force O(k^2) time O(1) space
    -----------
    Mr John Smith, 13
    Mr   John Smith
    Mr%20John Smith
    ...

    Shift operation
    0 1 2 3 4 5 6 7 8 9 10  11  12  13  14  15  16
    M r _ J o h n _ S m  i   t   h   _   _   _   _
    
    M r _ J o h n _ S m  i   t   _   _   h
    M r _ J o h n _ S m  i   _   _   t   h
    M r _ J o h n _ S m  _   _   i   t   h
    M r _ J o h n _ S _  _   m   i   t   h
    M r _ J o h n _ _ _  S   m   i   t   h
    M r _ J o h _ _ n _  S   m   i   t   h
    M r _ J o _ _ h n _  S   m   i   t   h
    M r _ J _ _ o h n _  S   m   i   t   h
    M r _ _ _ J o h n _  S   m   i   t   h
    M r % 2 0 J o h n _  S   m   i   t   h
    ...
    M r % 2 0 J o h n %  2   0   S   m   i   t   h

    for each character in the true string len
        if char is a space
            shift the characters after the space by 2 positions
            write the next three array slots with %20
            jump 2 positions

    shift the characters after the space by 2 positions
        start at len, working backwards, skip over any spaces, until you hit the original space position
        char at current position + 2 = current char
        current char = space
        replace the 3 spaces starting at the space position with "%20"
        increase len by 3

    Two Pass O(k), O(1) space
    --------
    Instead of shifting each character past each space by 2,
    do one pass to get the number of spaces and then
    another pass to shift each character by the number of spaces it was found
    past directly.

    Shift operation
    0 1 2 3 4 5 6 7 8 9 10  11  12  13  14  15  16
    M r _ J o h n _ S m  i   t   h   _   _   _   _
    
    M r _ J o h n _ S m  i   t   _   _   _   _   h
    M r _ J o h n _ S m  i   _   _   _   _   t   h
    M r _ J o h n _ S m  _   _   _   _   i   t   h
    M r _ J o h n _ S _  _   _   _   m   i   t   h
    M r _ J o h n _ _ %  2   0   S   m   i   t   h
    M r _ J o h _ _ n %  2   0   S   m   i   t   h
    M r _ J o _ _ h n %  2   0   S   m   i   t   h
    M r _ J _ _ o h n %  2   0   S   m   i   t   h
    M r _ _ _ J o h n %  2   0   S   m   i   t   h
    M r % 2 0 J o h n %  2   0   S   m   i   t   h
    ...
    M r % 2 0 J o h n %  2   0   S   m   i   t   h
*/

// These implementations convert between strings and char arrays
// because the EPI test framework doesn't really work
// on char arrays directly.
public class URLify {
    @EpiTest(testDataFile = "../test_data/ctci/urlify.tsv")
    public static String urlify(String in, int len) {
        char[] inArr = in.toCharArray();

        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (inArr[i] == ' ') {
                spaceCount++;
            }
        }

        int index = (len - 1) + (2 * spaceCount);

        for (int i = len - 1; i >= 0; i--) {
            if (inArr[i] == ' ') {
                inArr[index] = '0';
                inArr[index - 1] = '2';
                inArr[index - 2] = '%';
                index -= 3;
            } else {
                inArr[index--] = inArr[i];
            }
        }

        return new String(inArr);
    }

    @EpiTest(testDataFile = "../test_data/ctci/urlify.tsv")
    public static String urlifyBF(String in, int len) {
        char[] inArr = in.toCharArray();

        for (int i = 0; i < len; i++) {
            if (inArr[i] == ' ') {
                for (int j = len - 1; j > i; j--) {
                    if (inArr[j] != ' ') {
                        inArr[j + 2] = inArr[j];
                        inArr[j] = ' ';
                    }
                }
                inArr[i] = '%';
                inArr[i + 1] = '2';
                inArr[i + 2] = '0';
                len += 2;
                i += 2;
            }
        }

        return new String(inArr);
    }

    public static void main(String[] args) {
        System.exit(GenericTest.runFromAnnotations(args, "URLify.java", new Object() {
        }.getClass().getEnclosingClass()).ordinal());
    }
}
