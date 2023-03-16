package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import test_framework.TestFailure;
import test_framework.TimedExecutor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvenOddArray {

  public static void evenOddNaive(List<Integer> A) {
    List<Integer> res = new ArrayList<Integer>(Collections.nCopies(A.size(), 0));
    int resIdx = 0;
    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) % 2 == 0) {
        res.set(resIdx++, A.get(i));
      }
    }

    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) % 2 != 0) {
        res.set(resIdx++, A.get(i));
      }
    }

    for (int i = 0; i < A.size(); i++) {
      A.set(i, res.get(i));
    }
  }

  public static void evenOddTwoPtr(List<Integer> A) {
    List<Integer> res = new ArrayList<Integer>(Collections.nCopies(A.size(), 0));
    int resBegin = 0;
    int resEnd = A.size() - 1;
  
    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) % 2 == 0) {
        res.set(resBegin++, A.get(i));
      } else {
        res.set(resEnd--, A.get(i));
      }
    }

    for (int i = 0; i < A.size(); i++) {
      A.set(i, res.get(i));
    }
  }

  public static void evenOdd(List<Integer> A) {
    int aBegin = 0;
    int aEnd = A.size() - 1;
  
    while(aBegin < aEnd) {
      if (A.get(aBegin) % 2 == 0) {
        aBegin++;
      } else {
        Collections.swap(A, aBegin, aEnd--);
      }
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/even_odd_array.tsv")
  public static void evenOddWrapper(TimedExecutor executor, List<Integer> A)
      throws Exception {
    List<Integer> before = new ArrayList<>(A);
    executor.run(() -> evenOdd(A));

    boolean inOdd = false;
    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) % 2 == 0) {
        if (inOdd) {
          throw new TestFailure("Even elements appear in odd part");
        }
      } else {
        inOdd = true;
      }
    }
    List<Integer> after = new ArrayList<>(A);
    Collections.sort(before);
    Collections.sort(after);
    if (!before.equals(after)) {
      throw new TestFailure("Elements mismatch");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvenOddArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
