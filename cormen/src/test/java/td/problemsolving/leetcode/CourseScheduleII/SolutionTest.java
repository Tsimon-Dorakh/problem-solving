package td.problemsolving.leetcode.CourseScheduleII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findOrder() {
        int n;
        int[][] xss;
        int[] expected;

        n = 4;
        xss = new int[][]{new int[]{1, 0}, {2, 0}, {3, 1}, {3, 2},};
        expected = new int[]{0, 1, 2, 3};
        assertArrayEquals(expected, new Solution().findOrder(n, xss));

        n = 2;
        xss = new int[][]{new int[]{1, 0},};
        expected = new int[]{0,1};
        assertArrayEquals(expected, new Solution().findOrder(n, xss));
    }
}
