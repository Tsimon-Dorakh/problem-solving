package td.problemsolving.interviewbit.LongestCommonSubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        String x;
        String y;
        int expected;

        x = "abbcdgf";
        y = "bbadcgf";
        expected = 5;

        assertEquals(expected, new Solution().solve(x, y));
    }
}
