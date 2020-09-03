package td.problemsolving.interviewbit.RedundantBraces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void braces() {
        assertEquals(1, new Solution().braces("((a + b))"));
        assertEquals(0, new Solution().braces("(a + (a + b))"));
        assertEquals(0, new Solution().braces("((a + b) + a)"));
        assertEquals(1, new Solution().braces("(a)"));
        assertEquals(0, new Solution().braces("a + b"));
    }
}
