package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class ConvertBase {

  @EpiTest(testDataFile = "../test_data/epi/convert_base.tsv")
  public static String convertBase(String numAsString, int b1, int b2) {
    return "";
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ConvertBase.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
