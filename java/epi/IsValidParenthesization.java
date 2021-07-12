package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
public class IsValidParenthesization {
  @EpiTest(testDataFile = "../test_data/epi/is_valid_parenthesization.tsv")

  public static boolean isWellFormed(String s) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidParenthesization.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
