package td.problemsolving.interviewbit.RomanToInteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void romanToInt() {
        assertEquals(0, new Solution().romanToInt(""));
        assertEquals(14, new Solution().romanToInt("XIV"));
        assertEquals(20, new Solution().romanToInt("XX"));
        assertEquals(3999, new Solution().romanToInt("MMMCMXCIX"));
    }
}
