package td.problemsolving.interviewbit.BSTIterator;

import static org.junit.jupiter.api.Assertions.*;
import static td.problemsolving.interviewbit.common.TreeNode.createTree;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

class SolutionTest {
    @Test
    void test() {
        TreeNode input;
        List<Integer> result;
        List<Integer> expected;

        input = createTree(new Integer[]{14, 1, 20});
        Solution iterator = new Solution(input);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(14, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());

        input = createTree(new Integer[]{1, null, 2, null, null, null, 3});
        expected = ImmutableList.of(1, 2, 3);
        result = new ArrayList<>();
        iterator = new Solution(input);
        while (iterator.hasNext()) result.add(iterator.next());
        assertEquals(expected, result);

        input = createTree(new Integer[]{4, 2, 9, 1, 3, 8, 11, null, null, null, null, 7, null, 10, 12, null, null, null, null, null, null, null, null, 5, null, null, null, null, null, null, 13, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 6});
        expected = ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        result = new ArrayList<>();
        iterator = new Solution(input);
        while (iterator.hasNext()) result.add(iterator.next());
        assertEquals(expected, result);
    }
}
