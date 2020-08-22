package td.problemsolving.interviewbit.AntiDiagonals;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void diagonal() {
        ArrayList<ArrayList<Integer>> expected;
        ArrayList<ArrayList<Integer>> input;

        input = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 2, 3)),
                new ArrayList<>(ImmutableList.of(4, 5, 6)),
                new ArrayList<>(ImmutableList.of(7, 8, 9))
        ));

        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1)),
                new ArrayList<>(ImmutableList.of(2, 4)),
                new ArrayList<>(ImmutableList.of(3, 5, 7)),
                new ArrayList<>(ImmutableList.of(6, 8)),
                new ArrayList<>(ImmutableList.of(9))
        ));

        assertEquals(expected, new Solution().diagonal(input));

    }
}
