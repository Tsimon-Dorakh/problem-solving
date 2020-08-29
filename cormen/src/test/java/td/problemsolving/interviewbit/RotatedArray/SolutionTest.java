package td.problemsolving.interviewbit.RotatedArray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMin() {
        List<Integer> input;

        input = ImmutableList.of(4, 5, 6, 7, 0, 1, 2);
        assertEquals(0, new Solution().findMin(input));

        input = ImmutableList.of(1);
        assertEquals(1, new Solution().findMin(input));

        input = ImmutableList.of(5137, 5525, 9511, 13269, 16255, 16700, 19870, 23034, 29247, 29934, 34583, 41585, 42598, 44113, 46035, 50147, 50737, 57084, 65916, 76905, 84098, 85912, 92081, 92257, 95449);
        assertEquals(5137, new Solution().findMin(input));
    }
}
