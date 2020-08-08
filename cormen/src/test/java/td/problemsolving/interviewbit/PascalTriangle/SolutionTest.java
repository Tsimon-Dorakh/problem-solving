package td.problemsolving.interviewbit.PascalTriangle;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1)),
                new ArrayList<>(ImmutableList.of(1, 1)),
                new ArrayList<>(ImmutableList.of(1, 2, 1)),
                new ArrayList<>(ImmutableList.of(1, 3, 3, 1)),
                new ArrayList<>(ImmutableList.of(1, 4, 6, 4, 1))
        ));

        assertEquals(expected, new Solution().solve(5));

        expected = new ArrayList<>();

        assertEquals(expected, new Solution().solve(0));
    }
}
