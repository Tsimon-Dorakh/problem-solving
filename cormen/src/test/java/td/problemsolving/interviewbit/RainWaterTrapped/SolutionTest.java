package td.problemsolving.interviewbit.RainWaterTrapped;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void trap() {
        List<Integer> input;

        input = ImmutableList.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        assertEquals(6, new Solution().trap(input));

        input = ImmutableList.of(1, 2);
        assertEquals(0, new Solution().trap(input));
    }
}
