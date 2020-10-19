package td.problemsolving.interviewbit.BlackShapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void black() {
        String[] xs;
        int expected;

        xs = new String[] {
          "OOOXOOO",
          "OOXXOXO",
          "OXOOOXO",
        };
        expected = 3;
        assertEquals(expected, new Solution().black(xs));
    }
}
