package td.problemsolving.interviewbit.MergeOverlappingIntervals;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void merge() {
        ArrayList<Solution.Interval> input;
        ArrayList<Solution.Interval> expected;

        input = new ArrayList<>(ImmutableList.of(
                new Solution.Interval(1, 3),
                new Solution.Interval(2, 6),
                new Solution.Interval(8, 10),
                new Solution.Interval(15, 18)
        ));

        expected = new ArrayList<>(ImmutableList.of(
                new Solution.Interval(1, 6),
                new Solution.Interval(8, 10),
                new Solution.Interval(15, 18)
        ));

        assertEquals(expected, new Solution().merge(input));
    }
}
