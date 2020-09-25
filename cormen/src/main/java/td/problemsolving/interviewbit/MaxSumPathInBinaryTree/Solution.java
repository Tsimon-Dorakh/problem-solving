package td.problemsolving.interviewbit.MaxSumPathInBinaryTree;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Max Sum Path in Binary Tree
 * https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
 */
public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode a) {
        dfs(a);

        return max;
    }

    int dfs(TreeNode a) {
        if (a == null) return 0;

        int x = dfs(a.left);
        int y = dfs(a.right);

        max = Math.max(max, a.val + x + y);

        return Math.max(0, a.val + Math.max(x, y));
    }
}
