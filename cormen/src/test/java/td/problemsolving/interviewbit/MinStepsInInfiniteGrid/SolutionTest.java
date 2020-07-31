package td.problemsolving.interviewbit.MinStepsInInfiniteGrid;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest {
    @Test
    void coverPoints() {
        assertEquals(
                2,
                new Solution().coverPoints(
                        ImmutableList.of(0, 1, 1),
                        ImmutableList.of(0, 1, 2)
                )
        );
    }
}
