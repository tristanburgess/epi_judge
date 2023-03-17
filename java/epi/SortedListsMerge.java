package epi;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class SortedListsMerge {

  @EpiTest(testDataFile = "../test_data/epi/sorted_lists_merge.tsv")
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    ListNode<Integer> H = new ListNode<Integer>(0, null);
    ListNode<Integer> cur = H;
    ListNode<Integer> L1Cur = L1;
    ListNode<Integer> L2Cur = L2;

    while (L1Cur != null && L2Cur != null) {
      if (L1Cur.data <= L2Cur.data) {
        cur.next = L1Cur;
        L1Cur = L1Cur.next;
      } else {
        cur.next = L2Cur;
        L2Cur = L2Cur.next;
      }

      cur = cur.next;
    }

    cur.next = L1Cur != null ? L1Cur : L2Cur;
  
    return H.next;
  }

  @EpiTest(testDataFile = "../test_data/epi/sorted_lists_merge.tsv")
  public static ListNode<Integer> mergeTwoSortedListsDumb(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    if (L1 == null) {
      return L2;
    } else if (L2 == null) {
      return L1;
    }

    // Ensure smallest first key is seen in L1
    if (L1.data > L2.data) {
      ListNode<Integer> tmp = L1;
      L1 = L2;
      L2 = tmp;
    }
  
    ListNode<Integer> L1Cur = L1;
    ListNode<Integer> L2Cur = L2;
    while (L1Cur != null && L2Cur != null) {
      ListNode<Integer> L1Next = L1Cur.next;
      ListNode<Integer> L2Next = L2Cur.next;

      if (L1Next == null) {
        L1Cur.next = L2Cur;
        break;
      } else if (L1Next.data > L2Cur.data) {
        L1Cur.next = L2Cur;
        L2Cur.next = L1Next;
        L2Cur = L2Next;
      }

      L1Cur = L1Cur.next;
    }

    return L1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
