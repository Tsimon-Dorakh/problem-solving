package td.problemsolving.interviewbit.GenerateAllParentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isValid() {
        assertEquals(0, new Solution().isValid("([)]"));
        assertEquals(1, new Solution().isValid("()[]{}"));
        assertEquals(1, new Solution().isValid("()"));
        assertEquals(0, new Solution().isValid("(]"));
        assertEquals(0, new Solution().isValid("[{"));
    }
}
