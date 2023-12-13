package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class IntAsArrayIncrement {

  public static final int BASE = 10;

  @EpiTest(testDataFile = "../test_data/epi/int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
