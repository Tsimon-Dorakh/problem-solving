package td.problemsolving.interviewbit.ValidBSTFromPreorder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Valid BST from Preorder
 * https://www.interviewbit.com/problems/valid-bst-from-preorder/
 */
public class Solution {
    public int solve(ArrayList<Integer> xs) {
        Stack<Integer> s = new Stack<>();

        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;

        // Traverse given array
        for (int i = 0; i < xs.size(); i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (xs.get(i) < root) {
                return 0;
            }

            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < xs.get(i)) {
                root = s.peek();
                s.pop();
            }

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(xs.get(i));
        }

        return 1;
    }
}
