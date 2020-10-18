package td.problemsolving.interviewbit.SmallestMultipleWith0And1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void multiple() {
        int a;
        String expected;

        a = 1;
        expected = "1";
        assertEquals(expected, new Solution().multiple(a));

        a = 55;
        expected = "110";
        assertEquals(expected, new Solution().multiple(a));

        a = 3;
        expected = "111";
        assertEquals(expected, new Solution().multiple(a));

        a = 2;
        expected = "10";
        assertEquals(expected, new Solution().multiple(a));

        a = 7;
        expected = "1001";
        assertEquals(expected, new Solution().multiple(a));
    }
}
