package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MaxProductAllButOne {
  @EpiTest(testDataFile = "../test_data/epi/max_product_all_but_one.tsv")

  public static int findBiggestProductNMinusOneProduct(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaxProductAllButOne.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
