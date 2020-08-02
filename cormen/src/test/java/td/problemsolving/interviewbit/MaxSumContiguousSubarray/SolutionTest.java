package td.problemsolving.interviewbit.MaxSumContiguousSubarray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSubArray() {
        assertEquals(
                10,
                new Solution().maxSubArray(ImmutableList.of(1, 2, 3, 4, -10))
        );
        assertEquals(
                6,
                new Solution().maxSubArray(ImmutableList.of(-2, 1, -3, 4, -1, 2, 1, -5, 4))
        );
    }
}
