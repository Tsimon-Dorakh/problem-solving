package td.problemsolving.interviewbit.SetMatrixZeros;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void setZeroes() {
        ArrayList<ArrayList<Integer>> xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 0, 1)),
                new ArrayList<>(ImmutableList.of(1, 1, 1)),
                new ArrayList<>(ImmutableList.of(1, 1, 1))
        ));

        new Solution().setZeroes(xss);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(0, 0, 0)),
                new ArrayList<>(ImmutableList.of(1, 0, 1)),
                new ArrayList<>(ImmutableList.of(1, 0, 1))
        ));

        assertEquals(expected, xss);


        xss = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 0, 1)),
                new ArrayList<>(ImmutableList.of(1, 1, 1)),
                new ArrayList<>(ImmutableList.of(1, 0, 1))
        ));

        new Solution().setZeroes(xss);

        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(0, 0, 0)),
                new ArrayList<>(ImmutableList.of(1, 0, 1)),
                new ArrayList<>(ImmutableList.of(0, 0, 0))
        ));

        assertEquals(expected, xss);
    }
}
