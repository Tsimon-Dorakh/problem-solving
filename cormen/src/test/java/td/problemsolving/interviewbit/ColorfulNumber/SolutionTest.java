package td.problemsolving.interviewbit.ColorfulNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void colorful() {
        assertEquals(1, new Solution().colorful(3245));
        assertEquals(1, new Solution().colorful(23));
    }
}
