package ctci;

import java.util.List;

import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - Matrix is not necessarily square, M * N.
    - Can't do any better than O(MN) time since we need to look at each element.

    Let element at i, j be 0, then all of row i and column j should be set to 0, including (0, j) and (i, 0).
    Thus we can do one pass on the matrix setting row 0 and column 0 with all the 0s that should be fulfilled,
    and then another pass actually zeroing out everything needed. Care must be taken to zero out row and column 0
    last as needed.

    O(MN) time, O(1) space.
*/

public class ZeroMatrix {
    public static void zeroMatrixInPlace(List<List<Integer>> mat) {
        int m = mat.size();
        if (m == 0) {
            return;
        }
        int n = mat.get(0).size();
        if (n == 0) {
            return;
        }

        boolean zeroFirstRow = false;
        boolean zeroFirstColumn = false;
        for (int i = 0; i < n; i++) {
            if (mat.get(0).get(i) == 0) {
                zeroFirstRow = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (mat.get(i).get(0) == 0) {
                zeroFirstColumn = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat.get(i).get(j) == 0) {
                    mat.get(i).set(0, 0);
                    mat.get(0).set(j, 0);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (mat.get(i).get(0) == 0) {
                for (int j = 1; j < n; j++) {
                    mat.get(i).set(j, 0);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (mat.get(0).get(i) == 0) {
                for (int j = 1; j < m; j++) {
                    mat.get(j).set(i, 0);
                }
            }
        }

        if (zeroFirstRow) {
            for (int i = 0; i < n; i++) {
                mat.get(0).set(i, 0);
            }
        }
        if (zeroFirstColumn) {
            for (int i = 0; i < m; i++) {
                mat.get(i).set(0, 0);
            }
        }
    }

    @EpiTest(testDataFile = "../test_data/ctci/zero_matrix.tsv")
    public static List<List<Integer>> zeroMatrix(List<List<Integer>> mat) {
        zeroMatrixInPlace(mat);
        return mat;
    }

    public static void main(String[] args) {
        System.exit(GenericTest.runFromAnnotations(args, "ZeroMatrix.java", new Object() {
        }.getClass().getEnclosingClass()).ordinal());
    }
}
