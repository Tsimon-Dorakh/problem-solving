package td.problemsolving.interviewbit.LongestSubstringWithoutRepeat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, new Solution().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, new Solution().lengthOfLongestSubstring("bbbbb"));
    }
}
