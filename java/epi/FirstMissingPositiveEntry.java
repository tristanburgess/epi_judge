package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class FirstMissingPositiveEntry {
  @EpiTest(testDataFile = "../test_data/epi/first_missing_positive_entry.tsv")

  public static int findFirstMissingPositive(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "FirstMissingPositiveEntry.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
