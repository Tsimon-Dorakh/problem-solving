package td.problemsolving.interviewbit.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return treeToString(this);
    }

    public static TreeNode createTree(Integer[] xs) {
        return createTree(xs, 1);
    }

    public static TreeNode createTree(Integer[] xs, int l) {
        if (l > xs.length || xs[l - 1] == null) return null;

        TreeNode root = new TreeNode(xs[l - 1]);
        root.left = createTree(xs, 2 * l);
        root.right = createTree(xs, 2 * l + 1);

        return root;
    }

    static String treeToString(TreeNode a) {
        StringBuilder s = new StringBuilder();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(a);

        while (!queue.isEmpty()) {
            List<TreeNode> treeNodes = new ArrayList<>(queue);
            queue.clear();

            boolean allNulls = true;
            for (TreeNode treeNode : treeNodes) {
                allNulls &= treeNode == null;
            }

            if (!allNulls) {
                for (TreeNode treeNode : treeNodes) {
                    s.append(treeNode != null ? treeNode.val : "null").append(", ");

                    queue.add(treeNode != null ? treeNode.left : null);
                    queue.add(treeNode != null ? treeNode.right : null);
                }
            }
        }

        return s.toString();
    }

    public int depth() {
        return depth(this, -1, 0);
    }

    static int depth(TreeNode a, int current, int max) {
        current++;
        max = Math.max(max, current);

        if (a.left != null) max = Math.max(max, depth(a.left, current, max));
        if (a.right != null) max = Math.max(max, depth(a.right, current, max));

        return max;
    }

}
