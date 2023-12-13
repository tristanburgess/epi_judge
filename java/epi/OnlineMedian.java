package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.Iterator;
import java.util.List;

public class OnlineMedian {
  public static List<Double> onlineMedian(Iterator<Integer> sequence) {
    // TODO - you fill in here.
    return null;
  }

  @EpiTest(testDataFile = "../test_data/epi/online_median.tsv")
  public static List<Double> onlineMedianWrapper(List<Integer> sequence) {
    return onlineMedian(sequence.iterator());
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "OnlineMedian.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
