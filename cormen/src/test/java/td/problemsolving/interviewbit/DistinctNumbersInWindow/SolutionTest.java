package td.problemsolving.interviewbit.DistinctNumbersInWindow;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void dNums() {
        ArrayList<Integer> input;
        ArrayList<Integer> expected;

        input = new ArrayList<>(ImmutableList.of(1, 2, 1, 3, 4, 3));
        expected = new ArrayList<>(ImmutableList.of(2, 3, 3, 2));
        assertEquals(expected, new Solution().dNums(input, 3));

    }
}
