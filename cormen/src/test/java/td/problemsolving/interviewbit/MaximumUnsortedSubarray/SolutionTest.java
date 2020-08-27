package td.problemsolving.interviewbit.MaximumUnsortedSubarray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void subUnsort() {
        ArrayList<Integer> input;
        ArrayList<Integer> expected;

        input = new ArrayList<>(ImmutableList.of(1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19));
        expected = new ArrayList<>(ImmutableList.of(6, 11));
        assertEquals(expected, new Solution().subUnsort(input));

        input = new ArrayList<>(ImmutableList.of(3, 3, 4, 5, 5, 9, 11, 13, 14, 15, 15, 16, 15, 20, 16));
        expected = new ArrayList<>(ImmutableList.of(11, 14));
        assertEquals(expected, new Solution().subUnsort(input));

        input = new ArrayList<>(ImmutableList.of(4, 15, 4, 4, 15, 18, 20));
        expected = new ArrayList<>(ImmutableList.of(1, 3));
        assertEquals(expected, new Solution().subUnsort(input));

        input = new ArrayList<>(ImmutableList.of(1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15));
        expected = new ArrayList<>(ImmutableList.of(4, 10));
        assertEquals(expected, new Solution().subUnsort(input));

        input = new ArrayList<>(ImmutableList.of(1, 1));
        expected = new ArrayList<>(ImmutableList.of(-1));
        assertEquals(expected, new Solution().subUnsort(input));

        input = new ArrayList<>(ImmutableList.of(1, 3, 2, 4, 5));
        expected = new ArrayList<>(ImmutableList.of(1, 2));
        assertEquals(expected, new Solution().subUnsort(input));

        input = new ArrayList<>(ImmutableList.of(1, 2, 3, 4, 5));
        expected = new ArrayList<>(ImmutableList.of(-1));
        assertEquals(expected, new Solution().subUnsort(input));
    }
}
