package td.problemsolving.interviewbit.TwoSumBinaryTree;

import static org.junit.jupiter.api.Assertions.*;
import static td.problemsolving.interviewbit.common.TreeNode.createTree;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {

    @Test
    void t2Sum() {
        TreeNode input;

        input = createTree(new Integer[]{10, 9, 20});
        assertEquals(0, new Solution().t2Sum(input, 40));

        input = createTree(new Integer[]{12, 5, 14, null, 8, null, 18 });
        assertEquals(1, new Solution().t2Sum(input, 20));

        input = createTree(new Integer[]{14, 1, 20});
        assertEquals(1, new Solution().t2Sum(input, 21));

        input = createTree(new Integer[]{10, 9, 20});
//        System.out.println(input);
//        System.out.println(createTree(new Integer[]{100, 98, 102, 96, 99, null, null, null, 97}));
        assertEquals(1, new Solution().t2Sum(input, 19));

    }
}
