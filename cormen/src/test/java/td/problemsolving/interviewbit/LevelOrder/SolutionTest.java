package td.problemsolving.interviewbit.LevelOrder;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {

    @Test
    void levelOrder() {
        TreeNode a;
        ArrayList<ArrayList<Integer>> expected;

        a = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(3)),
                new ArrayList<>(ImmutableList.of(9, 20)),
                new ArrayList<>(ImmutableList.of(15, 7))
        ));

        assertEquals(expected, new Solution().levelOrder(a));
    }
}
