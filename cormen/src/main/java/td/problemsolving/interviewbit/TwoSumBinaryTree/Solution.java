package td.problemsolving.interviewbit.TwoSumBinaryTree;

import java.util.Stack;
import td.problemsolving.interviewbit.common.TreeNode;

/**
 * 2-Sum Binary Tree
 * https://www.interviewbit.com/problems/2sum-binary-tree/
 */
public class Solution {
    public int t2Sum(TreeNode a, int b) {
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();

        TreeNode l = a;
        TreeNode r = a;

        while ((l != null || left.size() > 0) && (r != null || right.size() > 0)) {
            while (l != null) {
                left.push(l);
                l = l.left;
            }

            while (r != null) {
                right.push(r);
                r = r.right;
            }

            int lval = left.peek().val;
            int rval = right.peek().val;

            if (lval == rval) break;

            int sum = lval + rval;

            if (sum == b) return 1;
            else if (sum > b) {
                r = right.peek().left;
                right.pop();
            } else {
                l = left.peek().right;
                left.pop();
            }
        }

        return 0;
    }
}
