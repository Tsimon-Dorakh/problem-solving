package td.problemsolving.interviewbit.NextGreater;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nextGreater() {
        ArrayList<Integer> input;
        ArrayList<Integer> expected;

        input = new ArrayList<>(ImmutableList.of(4, 5, 2, 10));
        expected = new ArrayList<>(ImmutableList.of(5, 10, 10, -1));
        assertEquals(expected, new Solution().nextGreater(input));

        input = new ArrayList<>(ImmutableList.of(3, 2, 1));
        expected = new ArrayList<>(ImmutableList.of(-1, -1, -1));
        assertEquals(expected, new Solution().nextGreater(input));

    }
}
