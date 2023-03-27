package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class IntersectSortedArrays {

  @EpiTest(testDataFile = "../test_data/epi/intersect_sorted_arrays.tsv")
  public static List<Integer> intersectTwoSortedArrays(List<Integer> a,
                                                       List<Integer> b) {
      List<Integer> out = new ArrayList<>();

      int aIdx = 0;
      int bIdx = 0;
      Integer curUniq = null;

      while (aIdx < a.size() && bIdx < b.size()) {
        Integer aC = a.get(aIdx);
        Integer bC = b.get(bIdx);

        if (aC.compareTo(bC) == 0 && (curUniq == null || aC.compareTo(curUniq) != 0)) {
          out.add(aC);
          curUniq = aC;
          aIdx++;
          bIdx++;
        } else if (aC.compareTo(bC) > 0) {
          bIdx++;
        } else {
          aIdx++;
        }
      }

      return out;
      
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
