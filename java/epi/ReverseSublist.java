package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class ReverseSublist {

  @EpiTest(testDataFile = "../test_data/epi/reverse_sublist.tsv")
  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
    
    if (L == null || start >= finish) {
      return L;
    }       
  
    ListNode<Integer> d = new ListNode<Integer>(0, L);
    ListNode<Integer> h = d;
                              
    for (int i = 1; i < start; i++) {
      h = h.next;
    }

    ListNode<Integer> p = h.next;
    for (int i = 0; i < (finish - start); i++) {
      ListNode<Integer> c = p.next;
      p.next = c.next;
      c.next = h.next;
      h.next = c;
    }

    return d.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
