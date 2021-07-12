package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class IntersectSortedArrays {
  @EpiTest(testDataFile = "../test_data/epi/intersect_sorted_arrays.tsv")

  public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                       List<Integer> B) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
