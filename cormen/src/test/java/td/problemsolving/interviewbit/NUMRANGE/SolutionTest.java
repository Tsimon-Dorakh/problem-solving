package td.problemsolving.interviewbit.NUMRANGE;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numRange() {
        ArrayList<Integer> xs;

        xs = new ArrayList<>(ImmutableList.of(8, 0, 5, 1));
        assertEquals(6, new Solution().numRange(xs, 3, 9));

        xs = new ArrayList<>(ImmutableList.of(8, 0, 4, 3, 2, 2, 1));
        assertEquals(11, new Solution().numRange(xs, 0, 6));

        xs = new ArrayList<>(ImmutableList.of(76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66));
        assertEquals(84, new Solution().numRange(xs, 98, 290));

        xs = new ArrayList<>(ImmutableList.of(10, 5, 1, 0, 2, 5));
        assertEquals(6, new Solution().numRange(xs, 6, 8));

        xs = new ArrayList<>(ImmutableList.of(0, 9, 3));
        assertEquals(4, new Solution().numRange(xs, 0, 9));

        xs = new ArrayList<>(ImmutableList.of(80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90));
        assertEquals(58, new Solution().numRange(xs, 99, 269));

        xs = new ArrayList<>(ImmutableList.of(1));
        assertEquals(0, new Solution().numRange(xs, 0, 0));

        xs = new ArrayList<>(ImmutableList.of(10, 5, 1, 0, 2));
        assertEquals(3, new Solution().numRange(xs, 6, 8));

        xs = new ArrayList<>(ImmutableList.of(10, 5, 1, 0, 2, 5));
        assertEquals(2, new Solution().numRange(xs, 5, 5));
    }
}
