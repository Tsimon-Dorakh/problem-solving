package td.problemsolving.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLongestSubstringTest {
    @Test
    void lengthOfLongestSubstringTest() {
        assertEquals(2, new LengthOfLongestSubstring().lengthOfLongestSubstring("abba"));
        assertEquals(3, new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
