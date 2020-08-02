package td.problemsolving.interviewbit.Partitions;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        assertEquals(
                2,
                new Solution().solve(5, new ArrayList<>(ImmutableList.of(1, 2, 3, 0, 3)))
        );
        assertEquals(
                1,
                new Solution().solve(5, new ArrayList<>(ImmutableList.of(0, 1, -1, 0)))
        );
        assertEquals(
                0,
                new Solution().solve(5, new ArrayList<>(ImmutableList.of(4, 1)))
        );
        assertEquals(
                28,
                new Solution().solve(5, new ArrayList<>(ImmutableList.of(0, 0, 0, 0, 0, 0, 0, 0, 0)))
        );
        assertEquals(
                0,
                new Solution().solve(5, new ArrayList<>(ImmutableList.of(2, 5, -2, 2, -3, -2, 3, 5, -5, -2)))
        );
        assertEquals(
                0,
                new Solution().solve(5, new ArrayList<>(ImmutableList.of(0, 2, -1, 2)))
        );
        assertEquals(
                0,
                new Solution().solve(5, new ArrayList<>(ImmutableList.of(1, 1, 1, 1, 1)))
        );
    }
}
