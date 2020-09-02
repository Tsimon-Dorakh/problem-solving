package td.problemsolving.interviewbit.MaxContinuousSeriesOf1s;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxone() {
        ArrayList<Integer> xs;
        ArrayList<Integer> expected;

        xs = new ArrayList<>(ImmutableList.of(1, 1, 0, 1, 1, 0, 0, 1, 1, 1));
        expected = new ArrayList<>(ImmutableList.of(0, 1, 2, 3, 4));
        assertEquals(expected, new Solution().maxone(xs, 1));

        xs = new ArrayList<>(ImmutableList.of(1, 1, 0, 0, 1, 1, 0, 1, 1, 1));
        expected = new ArrayList<>(ImmutableList.of(4, 5, 6, 7, 8, 9));
        assertEquals(expected, new Solution().maxone(xs, 1));
    }
}
