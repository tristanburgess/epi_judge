package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class Bonus {

  @EpiTest(testDataFile = "../test_data/epi/bonus.tsv")
  public static Integer calculateBonus(List<Integer> productivity) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Bonus.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
