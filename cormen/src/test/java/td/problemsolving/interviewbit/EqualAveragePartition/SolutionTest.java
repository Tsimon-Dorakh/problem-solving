package td.problemsolving.interviewbit.EqualAveragePartition;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void avgset() {
        ArrayList<Integer> xs;
        ArrayList<ArrayList<Integer>> expected;

        xs = new ArrayList<>(ImmutableList.of(16, 42, 18, 48, 26, 45, 46, 26, 25, 7, 7, 48, 30, 10, 10, 3, 1, 11, 33, 14, 21, 15));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 3, 7, 7, 10, 10, 26, 45, 46, 48, 48)),
                new ArrayList<>(ImmutableList.of(11, 14, 15, 16, 18, 21, 25, 26, 30, 33, 42))
        ));
        assertEquals(expected, new Solution().avgset(xs));

        xs = new ArrayList<>(ImmutableList.of(28, 10, 2, 44, 33, 31, 39, 46, 1, 24, 32, 31, 28, 9, 13, 40, 46, 1, 16, 18, 39, 13, 48, 5));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 1, 2, 16, 39, 46, 46, 48)),
                new ArrayList<>(ImmutableList.of(5, 9, 10, 13, 13, 18, 24, 28, 28, 31, 31, 32, 33, 39, 40, 44))
        ));
        assertEquals(expected, new Solution().avgset(xs));

        xs = new ArrayList<>(ImmutableList.of(2, 4, 6, 14, 15, 19, 24, 30, 30, 32, 32, 47));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(2, 4, 32, 47)),
                new ArrayList<>(ImmutableList.of(6, 14, 15, 19, 24, 30, 30, 32))
        ));
        assertEquals(expected, new Solution().avgset(xs));

        xs = new ArrayList<>(ImmutableList.of(1, 7, 15, 29, 11, 9));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(9, 15)),
                new ArrayList<>(ImmutableList.of(1, 7, 11, 29))
        ));
        assertEquals(expected, new Solution().avgset(xs));


        xs = new ArrayList<>(ImmutableList.of(18, 29, 0, 47, 0, 41, 40, 28, 7, 1));
        expected = new ArrayList<>(ImmutableList.of());
        assertEquals(expected, new Solution().avgset(xs));

        xs = new ArrayList<>(ImmutableList.of(5, 16, 3, 4, 5, 2, 16, 49, 10, 35, 33, 14, 30, 40, 22, 7, 24, 38, 47, 19, 42));
        expected = new ArrayList<>(ImmutableList.of());
        assertEquals(expected, new Solution().avgset(xs));
    }
}
