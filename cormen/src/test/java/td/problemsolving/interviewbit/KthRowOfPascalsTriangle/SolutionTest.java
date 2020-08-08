package td.problemsolving.interviewbit.KthRowOfPascalsTriangle;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getRow() {
        assertEquals(
                ImmutableList.of(1, 3, 3, 1),
                new Solution().getRow(3)
        );
        assertEquals(
                ImmutableList.of(1, 4, 6, 4, 1),
                new Solution().getRow(4)
        );
    }
}
