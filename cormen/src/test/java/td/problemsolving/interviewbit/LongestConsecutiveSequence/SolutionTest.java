package td.problemsolving.interviewbit.LongestConsecutiveSequence;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestConsecutive() {
        List<Integer> xs;

        xs = new ArrayList<>(ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5));
        assertEquals(5, new Solution().longestConsecutive(xs));

        xs = new ArrayList<>(ImmutableList.of(-5));
        assertEquals(1, new Solution().longestConsecutive(xs));

        xs = new ArrayList<>(ImmutableList.of(100, 4, 200, 1, 3, 2));
        assertEquals(4, new Solution().longestConsecutive(xs));
    }
}
