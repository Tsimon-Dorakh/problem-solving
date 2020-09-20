package td.problemsolving.interviewbit.NextPointerBinaryTree;

import td.problemsolving.interviewbit.common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Next Pointer Binary Tree
 * https://www.interviewbit.com/problems/next-pointer-binary-tree/
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        noAuxSpaceSolution(root);
    }

    void noAuxSpaceSolution(TreeLinkNode root) {
        if (root == null) return;

        TreeLinkNode nextLevelFirst = root;
        TreeLinkNode p;

        while (nextLevelFirst.left != null) {
            p = nextLevelFirst;
            nextLevelFirst = nextLevelFirst.left;

            while (p != null) {
                p.left.next = p.right;

                if (p.next != null) {
                    p.right.next = p.next.left;
                }

                p = p.next;
            }
        }
    }

    void auxSpaceSolution(TreeLinkNode root) {
        if (root == null) return;

        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int i = queue.size();
            TreeLinkNode next = null;

            while (i-- > 0) {
                TreeLinkNode current = queue.pollLast();

                if (current.right != null) queue.addFirst(current.right);
                if (current.left != null) queue.addFirst(current.left);

                current.next = next;
                next = current;
            }
        }
    }

}
