package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortIncreasingDecreasingArray {

  public enum PartitionInc {
      ASC(1),
      DESC(-1);

      public final int inc;

      private PartitionInc(int inc) {
          this.inc = inc;
      }
  }

  static class Partition {
    int lo;
    int hi;
    int inc;
    int idx;
    Integer val;

    public Partition(int lo, int hi, int inc, int idx, int val) {
      this.lo = lo;
      this.hi = hi;
      this.inc = inc;
      this.idx = idx;
      this.val = val;
    }
  }

  private static List<Partition> partition(List<Integer> A) {
    List<Partition> partitions = new ArrayList<>();

    int lo = 0;
    PartitionInc state = PartitionInc.ASC;
  
    for (int i = 1; i <= A.size(); i++) {
      if (state == PartitionInc.ASC && (i == A.size() || A.get(i - 1) > A.get(i))) {
        partitions.add(new Partition(lo, i, state.inc, lo, A.get(lo)));
        lo = i;
        state = PartitionInc.DESC;
      } else if (state == PartitionInc.DESC && (i == A.size() || A.get(i - 1) < A.get(i))) {
        partitions.add(new Partition(lo, i, state.inc, i - 1, A.get(i - 1)));
        lo = i;
        state = PartitionInc.ASC;
      }
    }

    return partitions;
  }


  @EpiTest(testDataFile = "../test_data/epi/sort_increasing_decreasing_array.tsv")
  public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
    List<Integer> out = new ArrayList<>();

    List<Partition> partitions = partition(A);
    PriorityQueue<Partition> pq = new PriorityQueue<>(partitions.size(), (a, b) -> a.val.compareTo(b.val));

    for (int i = 0; i < partitions.size(); i++) {
      pq.add(partitions.get(i));
    }

    while (!pq.isEmpty()) {
      Partition cur = pq.remove();
      out.add(cur.val);

      if (cur.idx + cur.inc >= cur.lo && cur.idx + cur.inc < cur.hi) {
        cur.idx += cur.inc;
        cur.val = A.get(cur.idx);
        pq.add(cur);
      }
    }

    return out;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortIncreasingDecreasingArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
