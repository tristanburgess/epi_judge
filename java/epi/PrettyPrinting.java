package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;
public class PrettyPrinting {
  @EpiTest(testDataFile = "../test_data/epi/pretty_printing.tsv")

  public static int minimumMessiness(List<String> words, int lineLength) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrettyPrinting.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
