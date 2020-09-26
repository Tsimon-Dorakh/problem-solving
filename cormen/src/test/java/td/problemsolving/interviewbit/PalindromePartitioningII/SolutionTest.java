package td.problemsolving.interviewbit.PalindromePartitioningII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minCut() {
        String s;
        int expected;

        s = "aab";
        expected = 1;
        assertEquals(expected, new Solution().minCut(s));

        s = "aba";
        expected = 0;
        assertEquals(expected, new Solution().minCut(s));

    }
}
