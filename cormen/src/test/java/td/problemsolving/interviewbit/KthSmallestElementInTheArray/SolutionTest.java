package td.problemsolving.interviewbit.KthSmallestElementInTheArray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void kthsmallest() {
        List<Integer> xs;
        xs = ImmutableList.of(2, 1, 4, 3, 2);

        assertEquals(2, new Solution().kthsmallest(xs, 3));
    }
}
