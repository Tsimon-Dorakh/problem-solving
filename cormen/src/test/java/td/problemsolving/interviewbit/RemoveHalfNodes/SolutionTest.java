package td.problemsolving.interviewbit.RemoveHalfNodes;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        TreeNode input;
        TreeNode expected;

        input = TreeNode.createTree(new Integer[]{1, 2, 3, 4});
        expected = TreeNode.createTree(new Integer[]{1, 4, 3});
        assertEquals(expected, new Solution().solve(input));

        input = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, null, 6});
        expected = TreeNode.createTree(new Integer[]{1, 2, 6, 4, 5});
        assertEquals(expected, new Solution().solve(input));
    }
}
