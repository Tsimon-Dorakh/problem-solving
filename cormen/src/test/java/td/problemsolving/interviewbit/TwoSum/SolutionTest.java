package td.problemsolving.interviewbit.TwoSum;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void twoSum() {
        ArrayList<Integer> input;
        ArrayList<Integer> expected;

        input = new ArrayList<>(ImmutableList.of(2, 7, 11, 15));
        expected = new ArrayList<>(ImmutableList.of(1, 2));
        assertEquals(expected, new Solution().twoSum(input, 9));

        input = new ArrayList<>(ImmutableList.of(2, 7, 11, 15));
        expected = new ArrayList<>(ImmutableList.of());
        assertEquals(expected, new Solution().twoSum(input, 10));
    }
}
