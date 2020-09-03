package td.problemsolving.interviewbit.FirstNonRepeatingCharacterInAStreamOfCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        assertEquals("aabbdd", new Solution().solve("abadbc"));
        assertEquals("aaabc#", new Solution().solve("abcabc"));
    }
}
