package epi;

import generic_types.BstNode;
import test_framework.EpiTest;
import test_framework.EpiTestComparator;
import test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class KLargestValuesInBst {
  @EpiTest(testDataFile = "../test_data/epi/k_largest_values_in_bst.tsv")

  public static List<Integer> findKLargestInBst(BstNode<Integer> tree, int k) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTestComparator
  public static BiPredicate<List<Integer>, List<Integer>> comp = (expected, result) -> {
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
            .runFromAnnotations(args, "KLargestValuesInBst.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
