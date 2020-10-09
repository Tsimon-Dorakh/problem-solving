package td.problemsolving.interviewbit.MajorityElement;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void majorityElement() {
        List<Integer> xs;
        int expected;

        xs = ImmutableList.of(2, 1, 2);
        expected = 2;
        assertEquals(expected, new Solution().majorityElement(xs));

        xs = ImmutableList.of(1, 1, 2);
        expected = 1;
        assertEquals(expected, new Solution().majorityElement(xs));
    }
}
