package td.problemsolving.interviewbit.ValidBinarySearchTree;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isValidBST() {
        TreeNode a;
        int expected;

        a = TreeNode.createTree(new Integer[]{1, 2, 3});
        expected = 0;
        assertEquals(expected, new Solution().isValidBST(a));
    }
}
