package td.problemsolving.interviewbit.SquareRootOfInteger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void sqrt() {
        int x;
        int expected;

        x = 169506351;
        expected = 13019;
        assertEquals(expected, new Solution().sqrt(x));

        x = 6;
        expected = 2;
        assertEquals(expected, new Solution().sqrt(x));

        x = 1;
        expected = 1;
        assertEquals(expected, new Solution().sqrt(x));

        x = 9;
        expected = 3;
        assertEquals(expected, new Solution().sqrt(x));

        x = 11;
        expected = 3;
        assertEquals(expected, new Solution().sqrt(x));

    }
}
