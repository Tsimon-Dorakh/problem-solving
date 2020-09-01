package td.problemsolving.interviewbit.CountTotalSetBits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        assertEquals(5, new Solution().solve(4));
        assertEquals(7, new Solution().solve(5));
        assertEquals(4, new Solution().solve(3));
        assertEquals(1, new Solution().solve(1));

    }
}
