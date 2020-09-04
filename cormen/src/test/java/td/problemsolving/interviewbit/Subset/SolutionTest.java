package td.problemsolving.interviewbit.Subset;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void subsets() {
        ArrayList<Integer> input;
        ArrayList<ArrayList<Integer>> expected;

        input = new ArrayList<>(ImmutableList.of(1));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of()),
                new ArrayList<>(ImmutableList.of(1))
        ));
        assertEquals(expected, new Solution().subsets(input));

        input = new ArrayList<>(ImmutableList.of(1, 2));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of()),
                new ArrayList<>(ImmutableList.of(1)),
                new ArrayList<>(ImmutableList.of(1, 2)),
                new ArrayList<>(ImmutableList.of(2))
        ));
        assertEquals(expected, new Solution().subsets(input));

        input = new ArrayList<>(ImmutableList.of(1, 2, 3));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of()),
                new ArrayList<>(ImmutableList.of(1)),
                new ArrayList<>(ImmutableList.of(1, 2)),
                new ArrayList<>(ImmutableList.of(1, 2, 3)),
                new ArrayList<>(ImmutableList.of(1, 3)),
                new ArrayList<>(ImmutableList.of(2)),
                new ArrayList<>(ImmutableList.of(2, 3)),
                new ArrayList<>(ImmutableList.of(3))
        ));
        assertEquals(expected, new Solution().subsets(input));
    }
}
