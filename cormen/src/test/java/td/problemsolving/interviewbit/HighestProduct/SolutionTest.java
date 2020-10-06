package td.problemsolving.interviewbit.HighestProduct;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxp3() {
        ArrayList<Integer> xs;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(100, 3, 0, -1, -50, -70));
        expected = 350000;
        assertEquals(expected, new Solution().maxp3(xs));

        xs = new ArrayList<>(ImmutableList.of(1, 2, 3, 4));
        expected = 24;
        assertEquals(expected, new Solution().maxp3(xs));

        xs = new ArrayList<>(ImmutableList.of(0, -1, 3, 100, 70, 50));
        expected = 350000;
        assertEquals(expected, new Solution().maxp3(xs));
    }
}
