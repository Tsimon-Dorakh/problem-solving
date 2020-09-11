package td.problemsolving.interviewbit.InorderTraversalOfCartesianTree;

import java.util.ArrayList;
import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Inorder Traversal of Cartesian Tree
 * https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> xs) {
        return buildTree(xs, 0, xs.size() - 1);
    }

    TreeNode buildTree(ArrayList<Integer> xs, int l, int r) {
        if (l > r) return null;

        int maxPosition = findMaxPosition(xs, l, r);
        TreeNode treeNode = new TreeNode(xs.get(maxPosition));
        treeNode.left = buildTree(xs, l, maxPosition - 1);
        treeNode.right = buildTree(xs, maxPosition + 1, r);

        return treeNode;
    }

    int findMaxPosition(ArrayList<Integer> xs, int l, int r) {
        int maxPosition = l++;

        while (l <= r) {
            if (xs.get(maxPosition) < xs.get(l)) {
                maxPosition = l;
            }

            l++;
        }

        return maxPosition;
    }
}
