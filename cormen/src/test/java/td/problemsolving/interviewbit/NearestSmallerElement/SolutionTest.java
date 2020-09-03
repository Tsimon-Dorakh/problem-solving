package td.problemsolving.interviewbit.NearestSmallerElement;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void prevSmaller() {
        ArrayList<Integer> input;
        ArrayList<Integer> expected;

        input = new ArrayList<>(ImmutableList.of(8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34));
        expected = new ArrayList<>(ImmutableList.of(-1, 8, 8, 8, 16, -1, -1, 7, 27, 7, 27, 7, -1, -1, 1, 1, 1, 1, 6, 16, 26, 26));
        assertEquals(expected, new Solution().prevSmaller(input));

        input = new ArrayList<>(ImmutableList.of(3, 2, 1));
        expected = new ArrayList<>(ImmutableList.of(-1, -1, -1));
        assertEquals(expected, new Solution().prevSmaller(input));

        input = new ArrayList<>(ImmutableList.of());
        expected = new ArrayList<>(ImmutableList.of());
        assertEquals(expected, new Solution().prevSmaller(input));

        input = new ArrayList<>(ImmutableList.of(4, 5, 2, 10, 8));
        expected = new ArrayList<>(ImmutableList.of(-1, 4, -1, 2, 2));
        assertEquals(expected, new Solution().prevSmaller(input));


    }
}
