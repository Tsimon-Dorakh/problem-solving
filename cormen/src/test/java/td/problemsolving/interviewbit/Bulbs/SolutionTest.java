package td.problemsolving.interviewbit.Bulbs;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void bulbs() {
        ArrayList<Integer> xs;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(0, 1, 0, 1));
        expected = 4;
        assertEquals(expected, new Solution().bulbs(xs));

        xs = new ArrayList<>(ImmutableList.of(1));
        expected = 0;
        assertEquals(expected, new Solution().bulbs(xs));

    }
}
