package td.problemsolving.interviewbit.MinSumPathInMatrix;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minPathSum() {
        ArrayList<ArrayList<Integer>> xss;
        int expected;

        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 3, 2)),
                new ArrayList<>(ImmutableList.of(4, 3, 1)),
                new ArrayList<>(ImmutableList.of(5, 6, 1))
        ));
        expected = 8;
        assertEquals(expected, new Solution().minPathSum(xss));
    }
}
