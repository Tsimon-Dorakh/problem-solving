package td.problemsolving.interviewbit.Seats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void seats() {
        String s;
        int expected;

        s = "....";
        expected = 0;
        assertEquals(expected, new Solution().seats(s));

        s = ".x.x.x..x";
        expected = 5;
        assertEquals(expected, new Solution().seats(s));

        s = "....x..xx...x..";
        expected = 5;
        assertEquals(expected, new Solution().seats(s));

    }
}
