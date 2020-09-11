package td.problemsolving.interviewbit.InvertTheBinaryTree;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Invert the Binary Tree
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 */

public class Solution {
    public TreeNode invertTree(TreeNode a) {
        if (a == null) return null;

        TreeNode tmp = invertTree(a.left);
        a.left = invertTree(a.right);
        a.right = tmp;

        return a;
    }
}
