package td.problemsolving.interviewbit.MaxSumWithoutAdjacentElements;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void adjacent() {
        ArrayList<ArrayList<Integer>> xs;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 2, 3, 4)),
                new ArrayList<>(ImmutableList.of(2, 3, 4, 5))
        ));
        expected = 8;
        assertEquals(expected, new Solution().adjacent(xs));

        xs = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(16, 5, 54, 55, 36, 82, 61, 77, 66, 61)),
                new ArrayList<>(ImmutableList.of(31, 30, 36, 70, 9, 37, 1, 11, 68, 14))
        ));
        expected = 321;
        assertEquals(expected, new Solution().adjacent(xs));

        xs = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1)),
                new ArrayList<>(ImmutableList.of(2))
        ));
        expected = 2;
        assertEquals(expected, new Solution().adjacent(xs));
    }
}
