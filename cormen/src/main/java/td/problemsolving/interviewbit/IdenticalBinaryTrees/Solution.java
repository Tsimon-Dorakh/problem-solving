package td.problemsolving.interviewbit.IdenticalBinaryTrees;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Identical Binary Trees
 * https://www.interviewbit.com/problems/identical-binary-trees/
 */
public class Solution {
    public int isSameTree(TreeNode a, TreeNode b) {
        return compareTrees(a, b) ? 1 : 0;
    }

    public boolean compareTrees(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return a.val == b.val && compareTrees(a.left, b.left) && compareTrees(a.right, b.right);
    }
}
