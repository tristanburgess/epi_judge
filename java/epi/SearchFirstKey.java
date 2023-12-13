package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class SearchFirstKey {

  @EpiTest(testDataFile = "../test_data/epi/search_first_key.tsv")
  public static int searchFirstOfK(List<Integer> A, int k) {
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchFirstKey.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
