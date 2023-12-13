package epi;

import test_framework.EpiTest;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import java.util.List;

public class SearchForMinMaxInArray {
  @EpiUserType(ctorParams = { Integer.class, Integer.class })

  public static class MinMax {
    public Integer smallest;
    public Integer largest;

    public MinMax(Integer smallest, Integer largest) {
      this.smallest = smallest;
      this.largest = largest;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      MinMax minMax = (MinMax) o;

      if (!smallest.equals(minMax.smallest)) {
        return false;
      }
      return largest.equals(minMax.largest);
    }

    @Override
    public String toString() {
      return "min: " + smallest + ", max: " + largest;
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/search_for_min_max_in_array.tsv")
  public static MinMax findMinMax(List<Integer> A) {
    // TODO - you fill in here.
    return new MinMax(0, 0);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchForMinMaxInArray.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
