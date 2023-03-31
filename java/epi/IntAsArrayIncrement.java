package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;
import java.util.List;

public class IntAsArrayIncrement {

  public static final int BASE = 10;

  @EpiTest(testDataFile = "../test_data/epi/int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    int end = A.size() - 1;
    int carry = 1;
  
    for (int i = end; carry == 1 && i >= 0; i--) {
      int inc = A.get(i) + carry;
      carry = inc / BASE;
      A.set(i, inc % BASE);
    }
  
    if (carry == 1) {
      A.set(0, 0);
      A.add(0, 1);
    }
  
    return A;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
