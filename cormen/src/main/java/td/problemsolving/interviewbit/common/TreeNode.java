package td.problemsolving.interviewbit.common;

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

}
