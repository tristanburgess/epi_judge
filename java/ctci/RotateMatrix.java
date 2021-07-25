package ctci;

import java.util.List;

import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Assume rotation should happen counter clockwise
    - Assume the rotation must happen in place
    - A square matrix is required (dimensions N*N)

    Can't do any better than N^2 since we have to touch each element
    in the N*N matrix. By requirements we can do this with O(1) space.

    Playing with an example
    -----------------------
    0  1  2  3          3 7 11 15
    4  5  6  7    =>    2 6 10 14
    8  9  10 11         1 5 9  13
    12 13 14 15         0 4 8  12

    0 4 8 12     transpose (i,j in the matrix swapped with j,i)
    1 5 9 13
    2 6 10 14
    3 7 11 15

    3 7 11 15    invert
    2 6 10 14
    1 5 9 13
    0 4 8 12

    Another way?
    -----------------------
    0  1  2  3          3 7 11 15
    4  5  6  7    =>    2 6 10 14
    8  9  10 11         1 5 9  13
    12 13 14 15         0 4 8  12

    3  7  11 15
    2  5  6  14
    1  9  10 13
    0  4  8  12

    3  7  11 15
    2  6  10 14
    1  5  9  13
    0  4  8  12
*/

public class RotateMatrix {
    public static void rotateBInPlace(List<List<Integer>> mat) {
        int n = mat.size();
        for (int bound = 0; bound < n / 2; bound++) {
            int first = bound;
            int last = n - 1 - bound;
            for (int i = first; i < last; i++) {
                int top = mat.get(first).get(i);
                int right = mat.get(i).get(last);
                int bot = mat.get(last).get(last - (i - first));
                int left = mat.get(last - (i - first)).get(first);
                
                // top = right
                mat.get(first).set(i, right);
                // right = bot
                mat.get(i).set(last, bot);
                // bot = left
                mat.get(last).set(last - (i - first), left);
                // left = top
                mat.get(last - (i - first)).set(first, top);
            }
        }
    }

    @EpiTest(testDataFile = "../test_data/ctci/rotate_matrix.tsv")
    public static List<List<Integer>> rotateBoundaries(List<List<Integer>> mat) {
        rotateBInPlace(mat);
        return mat;
    }

    public static void rotateTIInPlace(List<List<Integer>> mat) {
        int n = mat.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = mat.get(i).get(j);
                mat.get(i).set(j, mat.get(j).get(i));
                mat.get(j).set(i, tmp);
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = mat.get(i).get(j);
                mat.get(i).set(j, mat.get(n - 1 - i).get(j));
                mat.get(n - 1 - i).set(j, tmp);
            }
        }

    }

    @EpiTest(testDataFile = "../test_data/ctci/rotate_matrix.tsv")
    public static List<List<Integer>> rotateTransInvert(List<List<Integer>> mat) {
        rotateTIInPlace(mat);
        return mat;
    }

    public static void main(String[] args) {
        System.exit(GenericTest.runFromAnnotations(args, "RotateMatrix.java", new Object() {
        }.getClass().getEnclosingClass()).ordinal());
    }
}
