package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
public class EvaluateRpn {
  @EpiTest(testDataFile = "../test_data/epi/evaluate_rpn.tsv")

  public static int eval(String expression) {
    // TODO - you fill in here.
    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvaluateRpn.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
