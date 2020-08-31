package td.problemsolving.interviewbit.MinimumCharactersStringPalindromic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        assertEquals(2, new Solution().solve("AACECAAAA"));
        assertEquals(0, new Solution().solve("ABBA"));
        assertEquals(2, new Solution().solve("ABC"));
        assertEquals(19, new Solution().solve("mmtatbdzqsoemuvnpppsu"));
    }
}
