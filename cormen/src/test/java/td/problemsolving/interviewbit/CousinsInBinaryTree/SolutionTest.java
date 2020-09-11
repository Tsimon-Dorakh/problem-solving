package td.problemsolving.interviewbit.CousinsInBinaryTree;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        TreeNode input;
        ArrayList<Integer> expected;

        input = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        expected = new ArrayList<>(ImmutableList.of(6, 7));
        assertEquals(expected, new Solution().solve(input, 5));

        input = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, null, 6});
        expected = new ArrayList<>(ImmutableList.of());
        assertEquals(expected, new Solution().solve(input, 1));
    }
}
