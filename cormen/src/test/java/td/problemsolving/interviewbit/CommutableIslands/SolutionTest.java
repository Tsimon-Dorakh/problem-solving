package td.problemsolving.interviewbit.CommutableIslands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solve() {
        int a;
        int[][] xss;
        int expected;

        a = 4;
        xss = new int[][] {
                new int[]{1, 2, 1},
                new int[]{2, 3, 4},
                new int[]{1, 4, 3},
                new int[]{4, 3, 2},
                new int[]{1, 3, 10},
        };
        expected = 6;
        assertEquals(expected, new Solution().solve(a, xss));

        a = 4;
        xss = new int[][] {
                new int[]{1, 2, 1},
                new int[]{2, 3, 2},
                new int[]{3, 4, 4},
                new int[]{1, 4, 3},
        };
        expected = 6;
        assertEquals(expected, new Solution().solve(a, xss));
    }
}
