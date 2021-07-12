package epi;
import test_framework.EpiTest;
import test_framework.EpiTestComparator;
import test_framework.LexicographicalListComparator;
import test_framework.GenericTest;
import java.util.List;
import java.util.function.BiPredicate;
public class EnumeratePalindromicDecompositions {
  @EpiTest(testDataFile = "../test_data/epi/enumerate_palindromic_decompositions.tsv")

  public static List<List<String>> palindromeDecompositions(String input) {
    // TODO - you fill in here.
    return null;
  }
  @EpiTestComparator
  public static BiPredicate<List<List<String>>, List<List<String>>> comp =
      (expected, result) -> {
    if (result == null) {
      return false;
    }
    expected.sort(new LexicographicalListComparator<>());
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EnumeratePalindromicDecompositions.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
