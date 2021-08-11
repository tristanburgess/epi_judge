package ctci;

import generic_types.ListNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

/*  MY ANSWERS:

    Requirements
    ------------
    - List may be empty, has no cycles, singly linked
    - Partition element p can be anywhere in the right partition, does not need to be a separator
    - Element ordering within each partition does not matter
    - Partition value isn't necessarily found in the list

    Solution: O(n) time O(1) space
      - Can't do better than O(n), need to examine each element.
    --------
    Iterate through each list element, set a flag once the first element whose value is >= p is found.
    For each elemenent thereafter, if the next element's value is < p then the next element becomes the new head.
    This handles the case where the value of head >= p as well.

    What if we do require the partitioning to be stable?
    We can keep two separate lists for before and after and merge them, adding elements
    to each in exactly the order we find them.
*/

public class Partition {
  public static ListNode<Integer> partitionWorker(ListNode<Integer> head, int p) {
    boolean partitioned = false;
    ListNode<Integer> cur = head;
    while (cur != null && cur.next != null) {
      if (cur.data >= p) {
        partitioned = true;
      }

      if (partitioned && cur.next.data < p) {
        ListNode<Integer> nHead = cur.next;
        cur.next = cur.next.next;
        nHead.next = head;
        head = nHead;
      } else {
        cur = cur.next;
      }
    }

    return head;
  }

  @EpiTest(testDataFile = "../test_data/ctci/partition.tsv")
  public static ListNode<Integer> partition(ListNode<Integer> head, int p) {
    ListNode<Integer> nHead = partitionWorker(head, p);
    return nHead;
  }

  public static void main(String[] args) {
    System.exit(GenericTest.runFromAnnotations(args, "Partition.java", new Object() {
    }.getClass().getEnclosingClass()).ordinal());
  }
}
