package td.problemsolving.interviewbit.ValidPath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        int x;
        int y;
        int R;
        int[] xs;
        int[] ys;
        String expected;

        x = 70;
        y = 15;
        R = 7;
        xs = new int[]{44, 38, 64, 68,  1, 46, 29};
        ys = new int[]{15,  9, 10,  1, 11, 13,  8};
//        xs = new int[]{64, 46};
//        ys = new int[]{10, 13};
        expected = "NO";
        assertEquals(expected, new Solution().solve(x, y, xs.length, R, xs, ys));

        x = 58;
        y = 91;
        R = 8;
        xs = new int[]{40,  6, 36, 38, 23, 54};
        ys = new int[]{88, 14, 50, 10, 15,  5};
        expected = "YES";
        assertEquals(expected, new Solution().solve(x, y, xs.length, R, xs, ys));

        x = 2;
        y = 3;
        R = 1;
        xs = new int[]{2};
        ys = new int[]{3};
        expected = "NO";
        assertEquals(expected, new Solution().solve(x, y, xs.length, R, xs, ys));

        x = 4;
        y = 5;
        R = 1;
        xs = new int[]{2};
        ys = new int[]{3};
        expected = "YES";
        assertEquals(expected, new Solution().solve(x, y, xs.length, R, xs, ys));

    }
}
