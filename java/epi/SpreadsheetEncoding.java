package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class SpreadsheetEncoding {
  @EpiTest(testDataFile = "../test_data/epi/spreadsheet_encoding.tsv")

  public static int ssDecodeColID(final String col) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpreadsheetEncoding.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
