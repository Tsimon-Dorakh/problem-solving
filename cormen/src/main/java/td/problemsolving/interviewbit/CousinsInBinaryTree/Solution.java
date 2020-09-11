package td.problemsolving.interviewbit.CousinsInBinaryTree;

import td.problemsolving.interviewbit.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Cousins in Binary Tree
 * https://www.interviewbit.com/problems/cousins-in-binary-tree/
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        List<QueueItem> queue = new ArrayList<>();
        queue.add(new QueueItem(a, null));

        while (!queue.isEmpty()) {
            List<QueueItem> items = new ArrayList<>(queue);
            queue.clear();

            QueueItem target = findItem(items, b);
            if (target != null) {
                for (QueueItem item : items) {
                    if (item.parent != null && item.parent.val != target.parent.val) {
                        result.add(item.treeNode.val);
                    }
                }

                return result;
            } else {
                for (QueueItem item : items) {
                    if (item.treeNode.left != null) queue.add(new QueueItem(item.treeNode.left, item.treeNode));
                    if (item.treeNode.right != null) queue.add(new QueueItem(item.treeNode.right, item.treeNode));
                }
            }
        }

        return result;
    }

    QueueItem findItem(List<QueueItem> items, int b) {
        for (QueueItem item : items) {
            if (item.treeNode.val == b) return item;
        }

        return null;
    }

    class QueueItem {
        TreeNode treeNode;
        TreeNode parent;

        public QueueItem(TreeNode treeNode, TreeNode parent) {
            this.treeNode = treeNode;
            this.parent = parent;
        }
    }
}
