package epi;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import java.util.List;

public class Knapsack {
  @EpiUserType(ctorParams = { Integer.class, Integer.class })

  public static class Item {
    public Integer weight;
    public Integer value;

    public Item(Integer weight, Integer value) {
      this.weight = weight;
      this.value = value;
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/knapsack.tsv")

  public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Knapsack.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
