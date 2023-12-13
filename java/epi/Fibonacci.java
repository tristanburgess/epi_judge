package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class Fibonacci {

  @EpiTest(testDataFile = "../test_data/epi/fibonacci.tsv")

  public static int fibonacci(int n) {
    // TODO - you fill in here.
    return -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Fibonacci.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
