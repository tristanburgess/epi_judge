package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class InsertOperatorsInString {
  @EpiTest(testDataFile = "../test_data/epi/insert_operators_in_string.tsv")

  public static boolean expressionSynthesis(List<Integer> digits, int target) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "InsertOperatorsInString.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
