package td.problemsolving.interviewbit.BSTIterator;

import java.util.Stack;
import td.problemsolving.interviewbit.common.TreeNode;

/**
 * BST Iterator
 * https://www.interviewbit.com/problems/bst-iterator/
 */
public class Solution {
    Stack<TreeNode> stack = new Stack<>();

    public Solution(TreeNode root) {
        if (root != null) stackSmallest(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode treeNode = stack.pop();

        if (treeNode.right != null) {
            stackSmallest(treeNode.right);
        }

        return treeNode.val;
    }

    void stackSmallest(TreeNode a) {
        stack.push(a);

        if (a.left != null) {
            stackSmallest(a.left);
        }
    }
}
