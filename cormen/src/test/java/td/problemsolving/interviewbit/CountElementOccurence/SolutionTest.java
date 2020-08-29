package td.problemsolving.interviewbit.CountElementOccurence;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findCount() {
        List<Integer> input;

        input = ImmutableList.of(5, 7, 7, 8, 8, 10);
        assertEquals(2, new Solution().findCount(input, 8));

        input = ImmutableList.of(7, 7, 7, 7, 7, 7);
        assertEquals(6, new Solution().findCount(input, 7));

        input = ImmutableList.of(7, 7, 7, 7, 7, 7);
        assertEquals(0, new Solution().findCount(input, 6));
    }
}
