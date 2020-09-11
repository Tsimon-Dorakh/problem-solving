package td.problemsolving.interviewbit.PathSum;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void hasPathSum() {
        TreeNode a;
        int b;
        int expected;

        a = TreeNode.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1});
        b = 22;
        expected = 1;
        assertEquals(expected, new Solution().hasPathSum(a, b));
    }
}
