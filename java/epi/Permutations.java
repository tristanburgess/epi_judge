package epi;

import test_framework.EpiTest;
import test_framework.EpiTestComparator;
import test_framework.LexicographicalListComparator;
import test_framework.GenericTest;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class Permutations {
  @EpiTest(testDataFile = "../test_data/epi/permutations.tsv")

  public static List<List<Integer>> permutations(List<Integer> A) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTestComparator
  public static BiPredicate<List<List<Integer>>, List<List<Integer>>> comp = (expected, result) -> {
    if (result == null) {
      return false;
    }
    for (List<Integer> l : expected) {
      Collections.sort(l);
    }
    expected.sort(new LexicographicalListComparator<>());
    for (List<Integer> l : result) {
      Collections.sort(l);
    }
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Permutations.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
