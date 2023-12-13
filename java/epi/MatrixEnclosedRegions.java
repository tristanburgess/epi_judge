package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MatrixEnclosedRegions {

  public static void fillSurroundedRegions(List<List<Character>> board) {
    // TODO - you fill in here.
    return;
  }

  @EpiTest(testDataFile = "../test_data/epi/matrix_enclosed_regions.tsv")
  public static List<List<Character>> fillSurroundedRegionsWrapper(List<List<Character>> board) {
    fillSurroundedRegions(board);
    return board;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MatrixEnclosedRegions.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
