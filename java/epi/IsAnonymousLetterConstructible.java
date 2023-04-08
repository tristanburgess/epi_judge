package epi;
import java.util.HashMap;
import java.util.Map;

import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsAnonymousLetterConstructible {

  @EpiTest(testDataFile = "../test_data/epi/is_anonymous_letter_constructible.tsv")
  public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                          String magazineText) {
    Map<Character, Integer> m = new HashMap<>();

    for (Character c : letterText.toCharArray()) {
      m.putIfAbsent(c, 0);
      m.put(c, m.get(c) + 1);
    }

    for (Character c : magazineText.toCharArray()) {
      if (m.containsKey(c)) {
        Integer nf =  m.get(c) - 1;
        if (nf == 0) {
          m.remove(c);
          if (m.isEmpty()) {
            break;
          }
        } else {
          m.put(c, nf);
        }
      }
    }

    return m.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsAnonymousLetterConstructible.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
