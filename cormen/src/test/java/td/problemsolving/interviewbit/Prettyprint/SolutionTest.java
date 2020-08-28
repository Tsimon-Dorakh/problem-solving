package td.problemsolving.interviewbit.Prettyprint;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void prettyPrint() {
        ArrayList<ArrayList<Integer>> expected;

        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(3, 3, 3, 3, 3)),
                new ArrayList<>(ImmutableList.of(3, 2, 2, 2, 3)),
                new ArrayList<>(ImmutableList.of(3, 2, 1, 2, 3)),
                new ArrayList<>(ImmutableList.of(3, 2, 2, 2, 3)),
                new ArrayList<>(ImmutableList.of(3, 3, 3, 3, 3))
        ));

        assertEquals(expected, new Solution().prettyPrint(3));
    }
}
