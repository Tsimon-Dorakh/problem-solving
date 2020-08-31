package td.problemsolving.interviewbit.LengthOfLastWord;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lengthOfLastWord() {
        assertEquals(0, new Solution().lengthOfLastWord(""));
        assertEquals(5, new Solution().lengthOfLastWord("Hello World"));
        assertEquals(2, new Solution().lengthOfLastWord("a bc"));
        assertEquals(5, new Solution().lengthOfLastWord("World"));
    }
}
