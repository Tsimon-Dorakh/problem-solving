package td.problemsolving.interviewbit.CountAndSay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void countAndSay() {
        assertEquals("", new Solution().countAndSay(0));
        assertEquals("11", new Solution().countAndSay(2));
        assertEquals("111221", new Solution().countAndSay(5));
    }
}
