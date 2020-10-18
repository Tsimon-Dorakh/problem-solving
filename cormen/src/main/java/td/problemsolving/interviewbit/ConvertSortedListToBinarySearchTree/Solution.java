package td.problemsolving.interviewbit.ConvertSortedListToBinarySearchTree;

import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Convert Sorted List to Binary Search Tree
 * https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode a) {
        return createTreeNode(a, 0, getSize(a) - 1);
    }

    TreeNode createTreeNode(ListNode a, int from, int to) {
        if (a == null) return null;
        if (from > to) return null;

        int mid = (from + to) / 2;
        ListNode midListNode = getNth(a, mid - from);

        TreeNode node = new TreeNode(midListNode.val);
        node.left = createTreeNode(a, from, mid - 1);
        node.right = createTreeNode(midListNode.next, mid + 1, to);

        return node;
    }

    ListNode getNth(ListNode a, int n) {
        while (n-- > 0) a = a.next;

        return a;
    }

    int getSize(ListNode a) {
        int size = 0;

        while (a != null) {
            size++;
            a = a.next;
        }

        return size;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
