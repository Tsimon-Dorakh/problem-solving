package td.problemsolving.interviewbit.LeastCommonAncestor;

import td.problemsolving.interviewbit.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Least Common Ancestor
 * https://www.interviewbit.com/problems/least-common-ancestor/
 */
public class Solution {
    public int lca(TreeNode a, int b, int c) {
        return nSolution(a, b, c);
    }

    int nSolution(TreeNode a, int b, int c) {
        List<Integer> pathToB = pathTo(a, b);
        List<Integer> pathToC = pathTo(a, c);

        if (pathToB == null || pathToC == null) return -1;

        int r = Math.min(pathToB.size(), pathToC.size()) - 1;
        while (r >= 0) {
            if (pathToB.get(r).equals(pathToC.get(r))) return pathToB.get(r);
            r--;
        }

        throw new RuntimeException("Unsupported case");
    }

    List<Integer> pathTo(TreeNode a, int b) {
        if (a == null) return null;

        List<Integer> path = new ArrayList<>();
        path.add(a.val);

        if (a.val == b) {
            return path;
        } else {
            List<Integer> pathTo = pathTo(a.left, b);
            if (pathTo == null) pathTo = pathTo(a.right, b);
            if (pathTo == null) return null;

            path.addAll(pathTo);
        }

        return path;
    }

    int n2Solution(TreeNode a, int b, int c) {
        if (a == null) return -1;

        int val = n2Solution(a.left, b, c);
        if (val != -1) return val;

        val = n2Solution(a.right, b, c);
        if (val != -1) return val;

        return hasDescendant(a, b) && hasDescendant(a, c) ? a.val : -1;
    }

    boolean hasDescendant(TreeNode a, int b) {
        if (a == null) return false;
        if (a.val == b) return true;

        return hasDescendant(a.left, b) || hasDescendant(a.right, b);
    }
}
