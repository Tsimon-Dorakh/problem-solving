package td.problemsolving.interviewbit.MatrixMedian;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMedian() {
        ArrayList<ArrayList<Integer>> input;

        input = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 3, 5)),
                new ArrayList<>(ImmutableList.of(2, 6, 9)),
                new ArrayList<>(ImmutableList.of(3, 6, 9))
        ));

        assertEquals(5, new Solution().findMedian(input));
    }
}
