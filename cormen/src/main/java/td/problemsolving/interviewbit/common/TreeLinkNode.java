package td.problemsolving.interviewbit.common;

import java.util.Objects;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeLinkNode that = (TreeLinkNode) o;
        return val == that.val &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right, next);
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                '}';
    }

    public static TreeLinkNode createTree(Integer[] xs) {
        return createTree(xs, 1);
    }

    public static TreeLinkNode createTree(Integer[] xs, int l) {
        if (l > xs.length || xs[l - 1] == null) return null;

        TreeLinkNode root = new TreeLinkNode(xs[l - 1]);
        root.left = createTree(xs, 2 * l);
        root.right = createTree(xs, 2 * l + 1);

        return root;
    }

}
