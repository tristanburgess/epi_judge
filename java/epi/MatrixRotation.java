package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MatrixRotation {

  public static void rotateMatrix(List<List<Integer>> squareMatrix) {
    // TODO - you fill in here.
    return;
  }

  @EpiTest(testDataFile = "../test_data/epi/matrix_rotation.tsv")
  public static List<List<Integer>> rotateMatrixWrapper(List<List<Integer>> squareMatrix) {
    rotateMatrix(squareMatrix);
    return squareMatrix;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MatrixRotation.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
