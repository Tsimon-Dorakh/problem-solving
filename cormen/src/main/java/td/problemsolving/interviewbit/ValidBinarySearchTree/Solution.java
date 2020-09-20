package td.problemsolving.interviewbit.ValidBinarySearchTree;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Valid Binary Search Tree
 * https://www.interviewbit.com/problems/valid-binary-search-tree/
 */
public class Solution {
    public int isValidBST(TreeNode a) {
        return _isValidBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    boolean _isValidBST(TreeNode a, int min, int max) {
        boolean result = true;

        if (a == null) return result;
        if (a.val <= min || a.val >= max) return false;

        if (a.left != null) {
            result = a.val > a.left.val && _isValidBST(a.left, min, a.val);
        }

        if (a.right != null) {
            result = result && a.val < a.right.val && _isValidBST(a.right, a.val, max);
        }

        return result;
    }
}
