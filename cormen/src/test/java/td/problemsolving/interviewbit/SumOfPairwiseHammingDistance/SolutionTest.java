package td.problemsolving.interviewbit.SumOfPairwiseHammingDistance;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void hammingDistance() {
        assertEquals(
                8,
                new Solution().hammingDistance(ImmutableList.of(2, 4, 6))
        );
        assertEquals(
                104,
                new Solution().hammingDistance(ImmutableList.of(96, 96, 7, 81, 2, 13))
        );
    }
}
