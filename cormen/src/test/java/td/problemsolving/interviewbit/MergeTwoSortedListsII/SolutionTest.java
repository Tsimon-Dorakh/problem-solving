package td.problemsolving.interviewbit.MergeTwoSortedListsII;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void merge() {
        ArrayList<Integer> xs;
        ArrayList<Integer> ys;
        ArrayList<Integer> expected;

        xs = new ArrayList<>(ImmutableList.of(1, 5, 8));
        ys = new ArrayList<>(ImmutableList.of(6, 9));
        expected = new ArrayList<>(ImmutableList.of(1, 5, 6, 8, 9));
        new Solution().merge(xs, ys);
        assertEquals(expected, xs);

        xs = new ArrayList<>(ImmutableList.of());
        ys = new ArrayList<>(ImmutableList.of(6, 9));
        expected = new ArrayList<>(ImmutableList.of(6, 9));
        new Solution().merge(xs, ys);
        assertEquals(expected, xs);

        xs = new ArrayList<>(ImmutableList.of(6, 9));
        ys = new ArrayList<>(ImmutableList.of());
        expected = new ArrayList<>(ImmutableList.of(6, 9));
        new Solution().merge(xs, ys);
        assertEquals(expected, xs);

        xs = new ArrayList<>(ImmutableList.of(1));
        ys = new ArrayList<>(ImmutableList.of(1));
        expected = new ArrayList<>(ImmutableList.of(1, 1));
        new Solution().merge(xs, ys);
        assertEquals(expected, xs);

    }
}
