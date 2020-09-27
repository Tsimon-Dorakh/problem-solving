package td.problemsolving.interviewbit.LongestArithmeticProgression;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        List<Integer> xs;
        int expected;

        xs = ImmutableList.of(3, 6, 9, 12);
        expected = 4;
        assertEquals(expected, new Solution().solve(xs));

        xs = ImmutableList.of(9, 4, 7, 2, 10);
        expected = 3;
        assertEquals(expected, new Solution().solve(xs));
    }
}
