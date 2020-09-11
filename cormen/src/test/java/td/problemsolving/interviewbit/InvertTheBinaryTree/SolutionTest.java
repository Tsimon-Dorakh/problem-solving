package td.problemsolving.interviewbit.InvertTheBinaryTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {

    @Test
    void invertTree() {
        TreeNode a;
        TreeNode expected;

        a = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        expected = TreeNode.createTree(new Integer[]{1, 3, 2, 7, 6, 5, 4});
        assertEquals(expected, new Solution().invertTree(a));
    }
}
