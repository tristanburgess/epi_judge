package epi;
import test_framework.EpiTest;
import test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedArraysMerge {

  private static class Element {
    public Integer listIdx;
    public Integer listElemIdx;
    public Integer elem;

    public Element(Integer listIdx, Integer listElemIdx, Integer elem) {
      this.listIdx = listIdx;
      this.listElemIdx = listElemIdx;
      this.elem = elem;
    }
  }

  @EpiTest(testDataFile = "../test_data/epi/sorted_arrays_merge.tsv")
  public static List<Integer>
  mergeSortedArrays(List<List<Integer>> sortedArrays) {
    List<Integer> out = new ArrayList<>();
  
    PriorityQueue<Element> pq = new PriorityQueue<>(sortedArrays.size(), new Comparator<>() {
      @Override
      public int compare(Element a, Element b) {
        return a.elem.compareTo(b.elem);
      }
    });

    for (int i = 0; i < sortedArrays.size(); i++) {
      if (sortedArrays.get(i).size() > 0) {
        pq.add(new Element(i, 0, sortedArrays.get(i).get(0)));
      }
    }

    while (!pq.isEmpty()) {
      Element cur = pq.remove();
      out.add(cur.elem);
      if (cur.listElemIdx < sortedArrays.get(cur.listIdx).size() - 1) {
        Integer nextElem = sortedArrays.get(cur.listIdx).get(cur.listElemIdx + 1);
        pq.add(new Element(cur.listIdx, cur.listElemIdx + 1, nextElem));
      }
    }

    return out;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedArraysMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
