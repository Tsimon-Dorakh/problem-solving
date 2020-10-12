package td.problemsolving.interviewbit.DisjointIntervals;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<ArrayList<Integer>> xss;
        int expected;

        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(3, 5)),
                new ArrayList<>(ImmutableList.of(11, 15))
        ));
        expected = 2;
        assertEquals(expected, new Solution().solve(xss));

        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 4)),
                new ArrayList<>(ImmutableList.of(2, 3)),
                new ArrayList<>(ImmutableList.of(4, 6)),
                new ArrayList<>(ImmutableList.of(8, 9))
        ));
        expected = 3;
        assertEquals(expected, new Solution().solve(xss));
    }
}
