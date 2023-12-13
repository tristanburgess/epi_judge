package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class KthLargestInArray {
  // The numbering starts from one, i.e., if A = [3,1,-1,2] then
  // findKthLargest(A, 1) returns 3, findKthLargest(A, 2) returns 2,
  // findKthLargest(A, 3) returns 1, and findKthLargest(A, 4) returns -1.
  @EpiTest(testDataFile = "../test_data/epi/kth_largest_in_array.tsv")
  public static int findKthLargest(int k, List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KthLargestInArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
