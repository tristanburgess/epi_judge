package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class BuyAndSellStockTwice {
  @EpiTest(testDataFile = "../test_data/epi/buy_and_sell_stock_twice.tsv")
  public static double buyAndSellStockTwice(List<Double> prices) {
    // TODO - you fill in here.
    return 0.0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStockTwice.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
