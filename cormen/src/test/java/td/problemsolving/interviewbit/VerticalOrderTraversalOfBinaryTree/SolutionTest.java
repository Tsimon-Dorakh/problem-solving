package td.problemsolving.interviewbit.VerticalOrderTraversalOfBinaryTree;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void verticalOrderTraversal() {
        TreeNode input;
        ArrayList<ArrayList<Integer>> expected;

        input = TreeNode.createTree(new Integer[]{460, 3871, 4698, 8399, 504, 4421, 7515, null, 4167, 5727, null, null, 3096, 434, 7389, null, null, 2667, 5661, 1969, 7815, null, null, null, null, 4292, 3006, 9750, 6693, null, 6906, });
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(8399, 2667, 1969)),
                new ArrayList<>(ImmutableList.of(3871, 4167, 5727)),
                new ArrayList<>(ImmutableList.of(460, 504, 4421, 5661, 7815, 4292, 9750)),
                new ArrayList<>(ImmutableList.of(4698, 3096, 434)),
                new ArrayList<>(ImmutableList.of(7515, 3006, 6693)),
                new ArrayList<>(ImmutableList.of(7389)),
                new ArrayList<>(ImmutableList.of(6906))
        ));
        assertEquals(expected, new Solution().verticalOrderTraversal(input));

        input = TreeNode.createTree(new Integer[]{6, 3, 7, 2, 5, null, 9});
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(2)),
                new ArrayList<>(ImmutableList.of(3)),
                new ArrayList<>(ImmutableList.of(6, 5)),
                new ArrayList<>(ImmutableList.of(7)),
                new ArrayList<>(ImmutableList.of(9))
        ));
        assertEquals(expected, new Solution().verticalOrderTraversal(input));

        input = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5});
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(4)),
                new ArrayList<>(ImmutableList.of(2)),
                new ArrayList<>(ImmutableList.of(1, 5)),
                new ArrayList<>(ImmutableList.of(3))
        ));
        assertEquals(expected, new Solution().verticalOrderTraversal(input));
    }
}
