package td.problemsolving.interviewbit.ExcelColumnTitle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void convertToTitle() {
        assertEquals(
                "AZA",
                new Solution().convertToTitle(1353)
        );
        assertEquals(
                "A",
                new Solution().convertToTitle(1)
        );
        assertEquals(
                "AB",
                new Solution().convertToTitle(28)
        );

    }
}
