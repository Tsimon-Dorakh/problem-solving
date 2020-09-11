package td.problemsolving.interviewbit.FlattenBinaryTreeToLinkedList;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Flatten Binary Tree to Linked List
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {
    public TreeNode flatten(TreeNode a) {
        normalize(a);

        return a;
    }

    TreeNode normalize(TreeNode a) {
        if (a == null) return null;
        if (a.left == null && a.right == null) return a;

        TreeNode leftEnd = normalize(a.left);
        TreeNode rightEnd = normalize(a.right);

        if (a.left != null) {
            leftEnd.right = a.right;
            a.right = a.left;
            a.left = null;
        }

        return rightEnd != null ? rightEnd : leftEnd;
    }
}
