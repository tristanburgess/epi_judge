package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class MaximumSubarrayInCircularArray {
  @EpiTest(testDataFile = "../test_data/epi/maximum_subarray_in_circular_array.tsv")

  public static int maxSubarraySumInCircular(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaximumSubarrayInCircularArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
