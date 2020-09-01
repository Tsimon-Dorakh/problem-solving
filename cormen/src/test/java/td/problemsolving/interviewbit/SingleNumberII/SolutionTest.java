package td.problemsolving.interviewbit.SingleNumberII;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void singleNumber() {
        List<Integer> input;

        input = ImmutableList.of(1, 3, 3, 3, 2, 2, 2);
        assertEquals(1, new Solution().singleNumber(input));

        input = ImmutableList.of(1, 2, 4, 3, 3, 2, 2, 3, 1, 1);
        assertEquals(4, new Solution().singleNumber(input));

        input = ImmutableList.of(0, 0, 0, 1);
        assertEquals(1, new Solution().singleNumber(input));
    }
}
