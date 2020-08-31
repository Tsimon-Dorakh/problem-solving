package td.problemsolving.interviewbit.PalindromeString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isPalindrome() {
        assertEquals(1, new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(0, new Solution().isPalindrome("race a car"));
        assertEquals(0, new Solution().isPalindrome("1a2"));
    }
}
