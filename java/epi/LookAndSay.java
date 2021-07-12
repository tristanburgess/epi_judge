package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
public class LookAndSay {
  @EpiTest(testDataFile = "../test_data/epi/look_and_say.tsv")

  public static String lookAndSay(int n) {
    // TODO - you fill in here.
    return "";
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
