package td.problemsolving.interviewbit.NQueens;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solveNQueens() {
        ArrayList<ArrayList<String>> expected;

        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(
                        ".Q..",
                        "...Q",
                        "Q...",
                        "..Q.")),
                new ArrayList<>(ImmutableList.of(
                        "..Q.",
                        "Q...",
                        "...Q",
                        ".Q.."
                ))
        ));
        assertEquals(expected, new Solution().solveNQueens(4));
    }
}
