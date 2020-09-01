package td.problemsolving.interviewbit.MatrixSearch;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchMatrix() {
        ArrayList<ArrayList<Integer>> input;

        input = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1))
        ));
        assertEquals(1, new Solution().searchMatrix(input, 1));

        input = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1,   3,  5,  7)),
                new ArrayList<>(ImmutableList.of(10, 11, 16, 20)),
                new ArrayList<>(ImmutableList.of(23, 30, 34, 50))
        ));
        assertEquals(1, new Solution().searchMatrix(input, 3));

        input = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1,   3,  5,  7)),
                new ArrayList<>(ImmutableList.of(10, 11, 16, 20)),
                new ArrayList<>(ImmutableList.of(23, 30, 34, 50))
        ));
        assertEquals(0, new Solution().searchMatrix(input, 35));

    }
}
