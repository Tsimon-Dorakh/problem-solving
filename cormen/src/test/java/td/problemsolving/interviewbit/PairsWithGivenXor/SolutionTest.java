package td.problemsolving.interviewbit.PairsWithGivenXor;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<Integer> input;

        input = new ArrayList<>(ImmutableList.of(17, 18, 8, 13, 15, 7, 11, 5, 4, 9, 12, 6, 10, 14, 16, 3));
        assertEquals(5, new Solution().solve(input, 9));

        input = new ArrayList<>(ImmutableList.of(5, 4, 10, 15, 7, 6));
        assertEquals(1, new Solution().solve(input, 5));

        input = new ArrayList<>(ImmutableList.of(3, 6, 8, 10, 15, 50));
        assertEquals(2, new Solution().solve(input, 5));
    }
}
