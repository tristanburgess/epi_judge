package epi;

import test_framework.EpiTest;
import test_framework.EpiTestComparator;
import test_framework.EpiTestExpectedType;
import test_framework.EpiUserType;
import test_framework.GenericTest;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;

public class KClosestStars {
  @EpiUserType(ctorParams = { double.class, double.class, double.class })

  public static class Star implements Comparable<Star> {
    private double x, y, z;

    public Star(double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    public double distance() {
      return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public int compareTo(Star that) {
      return Double.compare(this.distance(), that.distance());
    }

    @Override
    public String toString() {
      return String.valueOf(distance());
    }
  }

  public static List<Star> findClosestKStars(Iterator<Star> stars, int k) {
    // TODO - you fill in here.
    return Collections.emptyList();
  }

  @EpiTest(testDataFile = "../test_data/epi/k_closest_stars.tsv")
  public static List<Star> findClosestKStarsWrapper(List<Star> stars, int k) {
    return findClosestKStars(stars.iterator(), k);
  }

  @EpiTestExpectedType
  public static List<Double> expectedType;

  @EpiTestComparator
  public static BiPredicate<List<Double>, List<Star>> comp = (expected, result) -> {
    if (expected.size() != result.size()) {
      return false;
    }
    Collections.sort(result);
    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).distance() != expected.get(i)) {
        return false;
      }
    }
    return true;
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KClosestStars.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
