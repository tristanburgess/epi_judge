package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class TwoSum {
  @EpiTest(testDataFile = "../test_data/epi/two_sum.tsv")

  public static boolean hasTwoSum(List<Integer> A, int t) {
    // TODO - you fill in here.
    return true;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TwoSum.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
