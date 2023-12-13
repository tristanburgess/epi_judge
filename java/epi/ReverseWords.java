package epi;

import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TimedExecutor;

public class ReverseWords {

  public static void reverseWords(char[] input) {
    // TODO - you fill in here.
    return;
  }

  @EpiTest(testDataFile = "../test_data/epi/reverse_words.tsv")
  public static String reverseWordsWrapper(TimedExecutor executor, String s)
      throws Exception {
    char[] sCopy = s.toCharArray();

    executor.run(() -> reverseWords(sCopy));

    return String.valueOf(sCopy);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseWords.java",
                new Object() {
                }.getClass().getEnclosingClass())
            .ordinal());
  }
}
