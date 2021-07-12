package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class PrimeSieve {
  @EpiTest(testDataFile = "../test_data/epi/prime_sieve.tsv")
  // Given n, return all primes up to and including n.
  public static List<Integer> generatePrimes(int n) {
    // TODO - you fill in here.
    return null;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimeSieve.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
