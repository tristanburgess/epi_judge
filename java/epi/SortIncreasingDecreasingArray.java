package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.List;

public class SortIncreasingDecreasingArray {

  @EpiTest(testDataFile = "../test_data/epi/sort_increasing_decreasing_array.tsv")
  public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortIncreasingDecreasingArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
