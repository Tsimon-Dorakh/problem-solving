package td.problemsolving.interviewbit.ExcelColumnNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void titleToNumber() {
        assertEquals(
                1353,
                new Solution().titleToNumber("AZA")
        );
        assertEquals(
                1,
                new Solution().titleToNumber("A")
        );
        assertEquals(
                28,
                new Solution().titleToNumber("AB")
        );
        assertEquals(
                703,
                new Solution().titleToNumber("AAA")
        );

    }
}
