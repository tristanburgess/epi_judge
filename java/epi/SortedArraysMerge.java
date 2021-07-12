package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class SortedArraysMerge {
  @EpiTest(testDataFile = "../test_data/epi/sorted_arrays_merge.tsv")

  public static List<Integer>
  mergeSortedArrays(List<List<Integer>> sortedArrays) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
