package td.problemsolving.interviewbit.LengthOfLongestSubsequence;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void longestSubsequenceLength() {
        List<Integer> xs;
        int expected;

        xs = ImmutableList.of(1, 11, 2, 10, 4, 5, 2, 1);
        expected = 6;
        assertEquals(expected, new Solution().longestSubsequenceLength(xs));

        xs = ImmutableList.of(1, 2, 1);
        expected = 3;
        assertEquals(expected, new Solution().longestSubsequenceLength(xs));
    }
}
