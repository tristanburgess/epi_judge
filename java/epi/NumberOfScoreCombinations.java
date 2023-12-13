package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class NumberOfScoreCombinations {
  @EpiTest(testDataFile = "../test_data/epi/number_of_score_combinations.tsv")

  public static int numCombinationsForFinalScore(int finalScore,
      List<Integer> individualPlayScores) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NumberOfScoreCombinations.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
