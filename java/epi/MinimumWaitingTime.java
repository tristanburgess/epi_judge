package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class MinimumWaitingTime {
  @EpiTest(testDataFile = "../test_data/epi/minimum_waiting_time.tsv")

  public static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MinimumWaitingTime.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
