package td.problemsolving.interviewbit.SingleNumber;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void singleNumber() {
        assertEquals(3, new Solution().singleNumber(ImmutableList.of(1, 2, 2, 3, 1)));
    }
}
