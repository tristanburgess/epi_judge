package epi;

import test_framework.EpiTest;
import test_framework.EpiTestComparator;
import test_framework.GenericTest;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class EnumerateBalancedParentheses {
  @EpiTest(testDataFile = "../test_data/epi/enumerate_balanced_parentheses.tsv")

  public static List<String> generateBalancedParentheses(int numPairs) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTestComparator
  public static BiPredicate<List<String>, List<String>> comp = (expected, result) -> {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EnumerateBalancedParentheses.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
