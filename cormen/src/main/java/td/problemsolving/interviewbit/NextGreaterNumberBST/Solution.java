package td.problemsolving.interviewbit.NextGreaterNumberBST;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Next Greater Number BST
 * https://www.interviewbit.com/problems/next-greater-number-bst/
 */
public class Solution {
    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode successor = null;

        while (a != null) {
            if (a.val > b) {
                successor = a;
                a = a.left;
            } else {
                a = a.right;
            }
        }

        return successor;
    }
}
