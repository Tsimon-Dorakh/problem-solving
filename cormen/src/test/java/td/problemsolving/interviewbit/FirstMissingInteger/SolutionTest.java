package td.problemsolving.interviewbit.FirstMissingInteger;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void firstMissingPositive() {
/*        assertEquals(
                3,
                new Solution().firstMissingPositive(new ArrayList<>(ImmutableList.of(0, 1, 2)))
        );
        assertEquals(
                2,
                new Solution().firstMissingPositive(new ArrayList<>(ImmutableList.of(3, 4, -1, 1)))
        );
        assertEquals(
                1,
                new Solution().firstMissingPositive(new ArrayList<>(ImmutableList.of(-8, -7, -6)))
        );*/
        assertEquals(
                2,
                new Solution().firstMissingPositive(new ArrayList<>(ImmutableList.of(1, 1, 1)))
        );
    }
}
