package td.problemsolving.interviewbit.RemoveHalfNodes;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Remove Half Nodes
 * https://www.interviewbit.com/problems/remove-half-nodes/
 */
public class Solution {
    public TreeNode solve(TreeNode a) {
        if (isHalfNode(a)) {
            if (a.left != null) return solve(a.left);
            else return solve(a.right);
        } else {
            if (a != null) {
                a.left = solve(a.left);
                a.right = solve(a.right);
            }

            return a;
        }
    }

    boolean isHalfNode(TreeNode a) {
        if (a == null) return false;

        return (a.left == null && a.right != null) ||
                (a.left != null && a.right == null);
    }
}
