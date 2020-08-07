package td.problemsolving.interviewbit.FindDuplicateInArray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void repeatedNumber() {
        assertEquals(
                4,
                new Solution().repeatedNumber(ImmutableList.of(3, 4, 1, 4, 1))
        );
    }
}
