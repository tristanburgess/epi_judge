package epi;

import generic_types.BinaryTreeNode;
import test_framework.EpiTest;
import test_framework.GenericTest;

public class IsTreeBalanced {

  private static class BalanceStatus {
    public boolean balanced;
    public int height;

    public BalanceStatus(boolean balanced, int height) {
      this.balanced = balanced;
      this.height = height;
    }
  }
  private static BalanceStatus computeStatus(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return new BalanceStatus(true, -1);
    }

    BalanceStatus leftStatus = computeStatus(tree.left);
    if (!leftStatus.balanced) {
      return leftStatus;
    }

    BalanceStatus rightStatus = computeStatus(tree.right);
    if (!rightStatus.balanced) {
      return rightStatus;
    }

    boolean balanced = Math.abs(leftStatus.height - rightStatus.height) <= 1;
    int height = 1 + Math.max(leftStatus.height, rightStatus.height);
    return new BalanceStatus(balanced, height);
  }
  @EpiTest(testDataFile = "../test_data/epi/is_tree_balanced.tsv")
  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    return computeStatus(tree).balanced;
  }

  private static int height(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return -1;
    }

    return 1 + Math.max(height(tree.left), height(tree.right));
  }

  @EpiTest(testDataFile = "../test_data/epi/is_tree_balanced.tsv")
  public static boolean isBalancedNaive(BinaryTreeNode<Integer> tree) {
    if (tree == null) {
      return true;
    }

    return Math.abs(height(tree.left) - height(tree.right)) <= 1 &&
      isBalancedNaive(tree.left) && isBalancedNaive(tree.right);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
