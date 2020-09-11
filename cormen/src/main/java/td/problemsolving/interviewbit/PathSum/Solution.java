package td.problemsolving.interviewbit.PathSum;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Path Sum
 * https://www.interviewbit.com/problems/path-sum/
 */
public class Solution {
    public int hasPathSum(TreeNode a, int b) {
        return hasPathSum(a, b, 0) ? 1 : 0;
    }

    public boolean hasPathSum(TreeNode a, int b, int sumSoFar) {
        if (a == null) return false;

        sumSoFar += a.val;
        if (sumSoFar == b && a.left == null && a.right == null) return true;

        return hasPathSum(a.left, b, sumSoFar) || hasPathSum(a.right, b, sumSoFar);
    }
}
