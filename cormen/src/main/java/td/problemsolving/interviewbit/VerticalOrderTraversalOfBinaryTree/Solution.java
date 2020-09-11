package td.problemsolving.interviewbit.VerticalOrderTraversalOfBinaryTree;

import td.problemsolving.interviewbit.common.TreeNode;

import java.util.*;

/**
 * Vertical Order traversal of Binary Tree
 * https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (a == null) return result;

        Map<Integer, ArrayList<Integer>> state = new HashMap<>();
        LinkedList<QueueItem> queue = new LinkedList<>();
        queue.addLast(new QueueItem(a, 0));

        while (!queue.isEmpty()) {
            QueueItem item = queue.getFirst();

            if (!state.containsKey(item.level)) state.put(item.level, new ArrayList<>());
            state.get(item.level).add(item.treeNode.val);

            if (item.treeNode.left != null) queue.push(new QueueItem(item.treeNode.left, item.level - 1));
            if (item.treeNode.right != null) queue.push(new QueueItem(item.treeNode.right, item.level + 1));
        }

        int minLevel = minLevel(state);
        int maxLevel = maxLevel(state);

        while (minLevel <= maxLevel) {
            result.add(state.get(minLevel));

            minLevel++;
        }

        return result;
    }

    class QueueItem {
        TreeNode treeNode;
        Integer level;

        public QueueItem(TreeNode treeNode, Integer level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    int minLevel(Map<Integer, ArrayList<Integer>> state) {
        int minLevel = state.keySet().iterator().next();

        for (Integer level : state.keySet()) {
            minLevel = Math.min(minLevel, level);
        }

        return minLevel;
    }

    int maxLevel(Map<Integer, ArrayList<Integer>> state) {
        int maxLevel = state.keySet().iterator().next();

        for (Integer level : state.keySet()) {
            maxLevel = Math.max(maxLevel, level);
        }

        return maxLevel;
    }
}
