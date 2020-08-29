package td.problemsolving.interviewbit.ImplementPowerFunction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void pow() {
        assertEquals(20805472, new Solution().pow(71045970, 41535484, 64735492));
        assertEquals(0, new Solution().pow(0, 0, 1));
        assertEquals(2, new Solution().pow(2, 3, 3));
        assertEquals(19, new Solution().pow(-1, 1, 20));
        assertEquals(47168647, new Solution().pow(79161127, 99046373, 57263970));
    }
}
