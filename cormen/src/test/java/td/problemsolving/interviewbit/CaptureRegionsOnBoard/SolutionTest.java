package td.problemsolving.interviewbit.CaptureRegionsOnBoard;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<ArrayList<Character>> xss;
        ArrayList<ArrayList<Character>> expected;

        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of('X', 'X', 'X', 'X')),
                new ArrayList<>(ImmutableList.of('X', 'O', 'O', 'X')),
                new ArrayList<>(ImmutableList.of('X', 'X', 'O', 'X')),
                new ArrayList<>(ImmutableList.of('X', 'O', 'X', 'X'))
        ));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of('X', 'X', 'X', 'X')),
                new ArrayList<>(ImmutableList.of('X', 'X', 'X', 'X')),
                new ArrayList<>(ImmutableList.of('X', 'X', 'X', 'X')),
                new ArrayList<>(ImmutableList.of('X', 'O', 'X', 'X'))
        ));
        new Solution().solve(xss);
        assertEquals(expected, xss);
    }
}
