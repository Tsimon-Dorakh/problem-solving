package td.problemsolving.interviewbit.ReverseString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseString() {
        assertEquals("cba", new Solution().reverseString("abc"));
    }
}
