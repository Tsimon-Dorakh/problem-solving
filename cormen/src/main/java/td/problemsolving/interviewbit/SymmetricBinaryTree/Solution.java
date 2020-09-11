package td.problemsolving.interviewbit.SymmetricBinaryTree;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Symmetric Binary Tree
 * https://www.interviewbit.com/problems/symmetric-binary-tree/
 */
public class Solution {
    public int isSymmetric(TreeNode a) {
        if (a == null) return 0;

        return compareSymmetric(a.left, a.right) ? 1 : 0;
    }

    boolean compareSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return a.val == b.val && compareSymmetric(a.left, b.right) && compareSymmetric(a.right, b.left);
    }
}
