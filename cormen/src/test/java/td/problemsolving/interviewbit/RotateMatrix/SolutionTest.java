package td.problemsolving.interviewbit.RotateMatrix;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void rotate() {
        ArrayList<ArrayList<Integer>> input;
        ArrayList<ArrayList<Integer>> expected;
        Solution solution = new Solution();

        input = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of( 1,  2,  3,  4)),
                new ArrayList<>(ImmutableList.of( 5,  6,  7,  8)),
                new ArrayList<>(ImmutableList.of( 9, 10, 11, 12)),
                new ArrayList<>(ImmutableList.of(13, 14, 15, 16))
        ));

        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(13, 9, 5, 1)),
                new ArrayList<>(ImmutableList.of(14, 10, 6, 2)),
                new ArrayList<>(ImmutableList.of(15, 11, 7, 3)),
                new ArrayList<>(ImmutableList.of(16, 12, 8, 4))
        ));

        solution.rotate(input);
        assertEquals(expected, input);

        input = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 2)),
                new ArrayList<>(ImmutableList.of(3, 4))
        ));

        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(3, 1)),
                new ArrayList<>(ImmutableList.of(4, 2))
        ));

        solution.rotate(input);
        assertEquals(expected, input);
    }
}
