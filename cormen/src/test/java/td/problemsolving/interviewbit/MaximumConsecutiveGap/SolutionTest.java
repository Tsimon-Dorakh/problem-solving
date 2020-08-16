package td.problemsolving.interviewbit.MaximumConsecutiveGap;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maximumGap() {
        assertEquals(
                2,
                new Solution().maximumGap(ImmutableList.of(1, 0, 3))
        );
        assertEquals(
                5,
                new Solution().maximumGap(ImmutableList.of(1, 10, 5))
        );
        assertEquals(
                1,
                new Solution().maximumGap(ImmutableList.of(4, 7, 7, 3, 6, 4, 3, 5, 8))
        );


        assertEquals(
                0,
                new Solution().maximumGap(ImmutableList.of(1, 1, 1))
        );

        assertEquals(
                1,
                new Solution().maximumGap(ImmutableList.of(1, 2, 3))
        );

        assertEquals(
                0,
                new Solution().maximumGap(ImmutableList.of(1))
        );


        assertEquals(
                1,
                new Solution().maximumGap(ImmutableList.of(1, 1, 2))
        );
    }
}
