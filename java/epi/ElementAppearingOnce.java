package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class ElementAppearingOnce {
  @EpiTest(testDataFile = "../test_data/epi/element_appearing_once.tsv")

  public static int findElementAppearsOnce(List<Integer> A) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ElementAppearingOnce.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
