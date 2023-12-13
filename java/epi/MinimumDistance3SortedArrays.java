package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MinimumDistance3SortedArrays {

  public static class ArrayData implements Comparable<ArrayData> {
    public int val;
    public int idx;

    public ArrayData(int idx, int val) {
      this.val = val;
      this.idx = idx;
    }

    @Override
    public int compareTo(ArrayData o) {
      int result = Integer.compare(val, o.val);
      if (result == 0) {
        result = Integer.compare(idx, o.idx);
      }
      return result;
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/minimum_distance_3_sorted_arrays.tsv")

  public static int findMinDistanceSortedArrays(List<List<Integer>> sortedArrays) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MinimumDistance3SortedArrays.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
