package td.problemsolving.interviewbit.KthSmallestElementInTree;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;
import static td.problemsolving.interviewbit.common.TreeNode.createTree;

class SolutionTest {

    @Test
    void kthsmallest() {
        TreeNode input;

        input = createTree(new Integer[]{2, 1, 3});
        assertEquals(2, new Solution().kthsmallest(input, 2));

    }
}
