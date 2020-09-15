package td.problemsolving.interviewbit.FlattenBinaryTreeToLinkedList;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void flatten() {
        TreeNode a;
        TreeNode expected;

        a = TreeNode.createTree(new Integer[]{1, 2, 3});
        expected = TreeNode.createTree(new Integer[]{1, null, 2, null, null, null, 3});
        assertEquals(expected, new Solution().flatten(a));
    }
}
