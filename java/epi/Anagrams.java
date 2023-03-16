package epi;
import test_framework.EpiTest;
import test_framework.EpiTestComparator;
import test_framework.LexicographicalListComparator;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

public class Anagrams {

  @EpiTest(testDataFile = "../test_data/epi/anagrams.tsv")
  public static List<List<String>> findAnagrams(List<String> dictionary) {
    List<List<String>> ans = new ArrayList<>();
    HashMap<String, List<String>> m = new HashMap<>();

    for (String word : dictionary) {
      char[] sArr = word.toCharArray();
      Arrays.sort(sArr);
      String sWord = new String(sArr);
      m.putIfAbsent(sWord, new ArrayList<>());
      m.get(sWord).add(word);
    }

    for (Map.Entry<String, List<String>> e : m.entrySet()) {
      if (e.getValue().size() >= 2) {
        ans.add(e.getValue());
      }
    }
  
    return ans;
  }

  @EpiTestComparator
  public static BiPredicate<List<List<String>>, List<List<String>>> comp =
      (expected, result) -> {
    if (result == null) {
      return false;
    }
    for (List<String> l : expected) {
      Collections.sort(l);
    }
    expected.sort(new LexicographicalListComparator<>());
    for (List<String> l : result) {
      Collections.sort(l);
    }
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Anagrams.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
