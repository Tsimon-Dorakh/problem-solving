package td.problemsolving.interviewbit.InorderTraversalOfCartesianTree;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {

    @Test
    void buildTree() {
        ArrayList<Integer> a;
        TreeNode expected;

        a = new ArrayList<>(ImmutableList.of(1, 2, 3));
        expected = TreeNode.createTree(new Integer[]{3, 2, null, 1});
        assertEquals(expected, new Solution().buildTree(a));

    }
}
