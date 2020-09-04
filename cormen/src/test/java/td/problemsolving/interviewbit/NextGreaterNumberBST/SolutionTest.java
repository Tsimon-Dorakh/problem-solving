package td.problemsolving.interviewbit.NextGreaterNumberBST;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;
import static td.problemsolving.interviewbit.common.TreeNode.createTree;

class SolutionTest {

    @Test
    void getSuccessor() {
        TreeNode input;
        TreeNode expected;

        input = createTree(new Integer[]{100, 98, 102, 96, 99, null, null, null, 97});
        expected = createTree(new Integer[]{98, 96, 99, null, 97});

        assertEquals(expected, new Solution().getSuccessor(input, 97));
    }


}
