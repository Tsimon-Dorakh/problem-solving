package td.problemsolving.interviewbit.MaxSumPathInBinaryTree;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {

    @Test
    void maxPathSum() {
        TreeNode a;
        int expected;

        a = TreeNode.createTree(new Integer[]{2, -1});
        expected = 2;
        assertEquals(expected, new Solution().maxPathSum(a));

        a = TreeNode.createTree(new Integer[]{-100, -200, null, -300, -400});
        expected = -100;
        assertEquals(expected, new Solution().maxPathSum(a));

        a = TreeNode.createTree(new Integer[]{1, 2, 3});
        expected = 6;
        assertEquals(expected, new Solution().maxPathSum(a));
    }
}
