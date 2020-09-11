package td.problemsolving.interviewbit.IdenticalBinaryTrees;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {

    @Test
    void isSameTree() {
        TreeNode a;
        TreeNode b;

        a = TreeNode.createTree(new Integer[]{1, 2, 3});
        b = TreeNode.createTree(new Integer[]{1, 2, 3});
        assertEquals(1, new Solution().isSameTree(a, b));

    }
}
