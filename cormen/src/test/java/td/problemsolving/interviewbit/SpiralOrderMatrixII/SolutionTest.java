package td.problemsolving.interviewbit.SpiralOrderMatrixII;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void generateMatrix() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 2, 3)),
                new ArrayList<>(ImmutableList.of(8, 9, 4)),
                new ArrayList<>(ImmutableList.of(7, 6, 5))
        ));

        assertEquals(
                expected,
                new Solution().generateMatrix(3)
        );

        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1,   2,  3, 4)),
                new ArrayList<>(ImmutableList.of(12, 13, 14, 5)),
                new ArrayList<>(ImmutableList.of(11, 16, 15, 6)),
                new ArrayList<>(ImmutableList.of(10,  9,  8, 7))
        ));

        assertEquals(
                expected,
                new Solution().generateMatrix(4)
        );
    }
}
