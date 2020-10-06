package td.problemsolving.interviewbit.MeetingRooms;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<ArrayList<Integer>> xss;
        int expected;

        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 18)),
                new ArrayList<>(ImmutableList.of(2, 11)),
                new ArrayList<>(ImmutableList.of(4, 15)),
                new ArrayList<>(ImmutableList.of(5, 13)),
                new ArrayList<>(ImmutableList.of(15, 29)),
                new ArrayList<>(ImmutableList.of(18, 23))
        ));
        expected = 4;
        assertEquals(expected, new Solution().solve(xss));

        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(0, 30)),
                new ArrayList<>(ImmutableList.of(5, 10)),
                new ArrayList<>(ImmutableList.of(15, 20))
        ));
        expected = 2;
        assertEquals(expected, new Solution().solve(xss));


        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 5)),
                new ArrayList<>(ImmutableList.of(2, 7)),
                new ArrayList<>(ImmutableList.of(6, 8))
        ));
        expected = 2;
        assertEquals(expected, new Solution().solve(xss));

        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 5)),
                new ArrayList<>(ImmutableList.of(2, 7)),
                new ArrayList<>(ImmutableList.of(6, 8)),
                new ArrayList<>(ImmutableList.of(6, 8)),
                new ArrayList<>(ImmutableList.of(6, 8))
        ));
        expected = 4;
        assertEquals(expected, new Solution().solve(xss));
    }
}
