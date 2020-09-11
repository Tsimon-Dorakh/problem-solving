package td.problemsolving.interviewbit.LeastCommonAncestor;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void lca() {
        TreeNode a;
        int b;
        int c;
        int expected;

        a = TreeNode.createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        b = 5;
        c = 1;
        expected = 3;
        assertEquals(expected, new Solution().lca(a, b, c));

        a = TreeNode.createTree(new Integer[]{1});
        b = 1;
        c = 1;
        expected = 1;
        assertEquals(expected, new Solution().lca(a, b, c));

    }
}
