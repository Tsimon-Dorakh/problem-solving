package td.problemsolving.interviewbit.UniqueBinarySearchTreesII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void numTrees() {
        int x;
        int expected;


        x = 3;
        expected = 5;
        assertEquals(expected, new Solution().numTrees(x));

        x = 5;
        expected = 42;
        assertEquals(expected, new Solution().numTrees(x));
    }
}
