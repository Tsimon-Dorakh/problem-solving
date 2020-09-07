package td.problemsolving.interviewbit.KthSmallestElementInTree;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Kth Smallest Element In Tree
 * https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 */
public class Solution {
    int visited = 0;
    int kth;

    public int kthsmallest(TreeNode a, int k) {
        inOrderTraversal(a, k);

        return kth;
    }

    void inOrderTraversal(TreeNode a, int k) {
        if (visited < k && a.left != null) inOrderTraversal(a.left, k);

        if (++visited == k) kth = a.val;

        if (visited < k && a.right != null) inOrderTraversal(a.right, k);
    }
}
