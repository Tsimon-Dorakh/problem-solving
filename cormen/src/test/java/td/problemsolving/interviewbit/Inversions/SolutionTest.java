package td.problemsolving.interviewbit.Inversions;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void countInversions() {
        ArrayList<Integer> xs;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(2, 4, 1, 3, 5));
        expected = 3;
        assertEquals(expected, new Solution().countInversions(xs));

        xs = new ArrayList<>(ImmutableList.of(2, 2));
        expected = 0;
        assertEquals(expected, new Solution().countInversions(xs));

        xs = new ArrayList<>(ImmutableList.of(2, 2, 1, 1));
        expected = 4;
        assertEquals(expected, new Solution().countInversions(xs));

        xs = new ArrayList<>(ImmutableList.of(84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60));
        expected = 290;
        assertEquals(expected, new Solution().countInversions(xs));
    }
}
