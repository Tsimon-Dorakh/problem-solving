package td.problemsolving.interviewbit.LargestDistanceBetweenNodesOfATree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        int[] xs;
        int expected;

        xs = new int[]{-1};
        expected = 0;
        assertEquals(expected, new Solution().solve(xs));

        xs = new int[]{-1, 0, 1, 1, 3, 0, 4, 0, 2, 8, 9, 0, 4, 6, 12, 14, 7, 9, 6, 4, 14, 13, 1, 9, 16, 17, 17, 0, 21, 10, 13, 14, 25, 28, 27, 0, 35, 20, 34, 23, 37, 3, 6, 25, 30, 22, 15, 37, 8, 6, 11, 22, 50, 12, 4, 2, 54, 23, 18, 52, 34, 49, 61, 8, 15, 63, 31, 51, 48, 41, 26, 37, 30, 15, 59, 12, 0, 40, 37, 73, 32, 19, 70, 29, 8, 21, 83, 33, 7, 13, 12, 82, 43, 86, 38, 31, 1, 84, 62, 83};
        expected = 16;
        assertEquals(expected, new Solution().solve(xs));

        xs = new int[]{-1, 0, 1, 1, 2, 0, 5, 0, 3, 0, 0, 2, 3, 1, 12, 14, 0, 5, 9, 6, 16, 0, 13, 4, 17, 2, 1, 22, 14, 20, 10, 17, 0, 32, 15, 34, 10, 19, 3, 22, 29, 2, 36, 16, 15, 37, 38, 27, 31, 12, 24, 29, 17, 29, 32, 45, 40, 15, 35, 13, 25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18, 5, 44, 29, 30, 9, 29, 30, 8, 57, 8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87, 49, 90, 6, 81, 73, 10, 8, 16};
        expected = 14;
        assertEquals(expected, new Solution().solve(xs));

        xs = new int[]{-1, 0, 0, 0, 3};
        expected = 3;
        assertEquals(expected, new Solution().solve(xs));
    }
}
