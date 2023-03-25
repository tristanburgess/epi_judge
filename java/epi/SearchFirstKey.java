package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class SearchFirstKey {

  @EpiTest(testDataFile = "../test_data/epi/search_first_key.tsv")
  public static int searchFirstOfK(List<Integer> A, int k) {
    int lo = 0;
    int hi = A.size() - 1;
    int out = -1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (k > A.get(mid)) {
        lo = mid + 1;
      } else if (k < A.get(mid)) {
        hi = mid - 1;
      } else {
        out = mid;
        hi = mid - 1;
      }
    }
  
    return out;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SearchFirstKey.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
