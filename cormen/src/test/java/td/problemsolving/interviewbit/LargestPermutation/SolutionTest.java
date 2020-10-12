package td.problemsolving.interviewbit.LargestPermutation;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solve() {
        int[] xs;
        int b;
        int[] expected;

        xs = new int[]{1, 2, 3, 4};
        b = 1;
        expected = new int[]{4, 2, 3, 1};
        assertArrayEquals(expected, new Solution().solve(xs, b));

        xs = new int[]{3, 2, 1};
        b = 2;
        expected = new int[]{3, 2, 1};
        assertArrayEquals(expected, new Solution().solve(xs, b));
    }
}
