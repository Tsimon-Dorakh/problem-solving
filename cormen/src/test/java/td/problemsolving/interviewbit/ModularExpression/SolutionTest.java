package td.problemsolving.interviewbit.ModularExpression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mod() {
        assertEquals(0, new Solution().Mod(0, 0, 1));
        assertEquals(19, new Solution().Mod(-1, 1, 20));
        assertEquals(2, new Solution().Mod(2, 3, 3));

    }
}
