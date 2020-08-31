package td.problemsolving.interviewbit.CompareVersionNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void compareVersion() {
        assertEquals(1, new Solution().compareVersion("4444371174137455", "5.168"));
        assertEquals(1, new Solution().compareVersion("2.2", "2.1"));
        assertEquals(-1, new Solution().compareVersion("1.2", "2.1"));
        assertEquals(-1, new Solution().compareVersion("", "1"));
        assertEquals(1, new Solution().compareVersion("1", ""));
        assertEquals(0, new Solution().compareVersion("1", "1"));
        assertEquals(-1, new Solution().compareVersion("1.13", "1.13.4"));
        assertEquals(1, new Solution().compareVersion("1.13.4", "1.13"));
        assertEquals(0, new Solution().compareVersion("01", "1"));
        assertEquals(0, new Solution().compareVersion("1.0", "1"));
    }
}
