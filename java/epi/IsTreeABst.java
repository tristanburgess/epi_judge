package epi;

import java.util.LinkedList;
import java.util.Queue;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsTreeABst {

  private static class QueueNode {
    BinaryTreeNode<Integer> node;
    Integer min;
    Integer max;

    public QueueNode(BinaryTreeNode<Integer> node, Integer min, Integer max) {
      this.node = node;
      this.min = min;
      this.max = max;
    }
  }
  @EpiTest(testDataFile = "../test_data/epi/is_tree_a_bst.tsv")
  public static boolean isBinaryTreeBSTBFS(BinaryTreeNode<Integer> tree) {
    Queue<QueueNode> q = new LinkedList<>();
    q.add(new QueueNode(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));

    while (!q.isEmpty()) {
      QueueNode h = q.remove();
      if (h.node != null) {
        if (h.node.data.compareTo(h.min) < 0 || h.node.data.compareTo(h.max) > 0) {
          return false;
        }

        q.add(new QueueNode(h.node.left, h.min, h.node.data));
        q.add(new QueueNode(h.node.right, h.node.data, h.max));
      }
    }

    return true;
  }

  private static Integer prev;
  private static boolean inorder(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return true;
    }

    if (!inorder(tree.left)) {
      return false;
    }
    if (prev != null && tree.data < prev) {
      return false;
    }
    prev = tree.data;
    return inorder(tree.right);
  }
  @EpiTest(testDataFile = "../test_data/epi/is_tree_a_bst.tsv")
  public static boolean isBinaryTreeBSTInorder(BinaryTreeNode<Integer> tree) {
    prev = null;
    return inorder(tree);
  }

  private static boolean areKeysInRange(BinaryTreeNode<Integer> tree, Integer lo, Integer hi) {
    if (tree == null) {
      return true;
    }

    if (tree.data.compareTo(lo) < 0 || tree.data.compareTo(hi) > 0) {
      return false;
    }

    return areKeysInRange(tree.left, lo, tree.data) && areKeysInRange(tree.right, tree.data, hi);
  }
  @EpiTest(testDataFile = "../test_data/epi/is_tree_a_bst.tsv")
  public static boolean isBinaryTreeBSTRangeFunc(BinaryTreeNode<Integer> tree) {
    return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static class BSTStatus {
    public boolean satisfied;
    public int min;
    public int max;

    public BSTStatus(boolean satisfied, int min, int max) {
      this.satisfied = satisfied;
      this.min = min;
      this.max = max;
    }
  }
  private static BSTStatus computeStatus(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return new BSTStatus(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    BSTStatus leftStatus = computeStatus(tree.left);
    if (!leftStatus.satisfied) {
      return leftStatus;
    }

    BSTStatus rightStatus = computeStatus(tree.right);
    if (!rightStatus.satisfied) {
      return rightStatus;
    }

    boolean satisfied = !(tree.data.compareTo(leftStatus.max) < 0 || tree.data.compareTo(rightStatus.min) > 0);
    int min = Math.min(tree.data, leftStatus.min);
    int max = Math.max(tree.data, rightStatus.max);
    return new BSTStatus(satisfied, min, max);
  }
  @EpiTest(testDataFile = "../test_data/epi/is_tree_a_bst.tsv")
  public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
    return computeStatus(tree).satisfied;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
