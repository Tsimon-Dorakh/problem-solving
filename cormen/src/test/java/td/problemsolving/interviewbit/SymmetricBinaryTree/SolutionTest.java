package td.problemsolving.interviewbit.SymmetricBinaryTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {

    @Test
    void isSymmetric() {
        TreeNode a;

        a = TreeNode.createTree(new Integer[]{1});
        assertEquals(1, new Solution().isSymmetric(a));

        a = TreeNode.createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        assertEquals(1, new Solution().isSymmetric(a));

        a = TreeNode.createTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        assertEquals(0, new Solution().isSymmetric(a));
    }
}
