package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.List;

public class TwoSortedArraysMerge {

  public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                          List<Integer> B, int n) {

    int curA = m - 1;
    int curB = n - 1;
    int c = m + n - 1;

    for (int i = c; i >= 0; i--) {
      if (curA < 0 || (curB >= 0 && A.get(curA) < B.get(curB))) {
        A.set(i, B.get(curB--));
      } else if (curB < 0 || (curA >= 0 && A.get(curA) >= B.get(curB))) {
        A.set(i, A.get(curA--));
      }
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/two_sorted_arrays_merge.tsv")
  public static List<Integer>
  mergeTwoSortedArraysWrapper(List<Integer> A, int m, List<Integer> B, int n) {
    mergeTwoSortedArrays(A, m, B, n);
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TwoSortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
