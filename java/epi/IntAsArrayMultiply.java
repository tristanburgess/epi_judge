package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class IntAsArrayMultiply {
  @EpiTest(testDataFile = "../test_data/epi/int_as_array_multiply.tsv")
  public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayMultiply.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
