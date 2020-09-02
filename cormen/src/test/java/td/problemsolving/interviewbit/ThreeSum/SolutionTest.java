package td.problemsolving.interviewbit.ThreeSum;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void threeSumClosest() {
        ArrayList<Integer> xs;
        int a;

        xs = new ArrayList<>(ImmutableList.of(2147483647, -2147483648, -2147483648, 0, 1));
        a = 0;
        assertEquals(0, new Solution().threeSumClosest(xs, a));

        xs = new ArrayList<>(ImmutableList.of(3, 0, -2, 9, -10, 0));
        a = -1;
        assertEquals(-1, new Solution().threeSumClosest(xs, a));

        xs = new ArrayList<>(ImmutableList.of(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
        a = -1;
        assertEquals(-1, new Solution().threeSumClosest(xs, a));

        xs = new ArrayList<>(ImmutableList.of(-1, 2, 1, -4));
        a = 1;
        assertEquals(2, new Solution().threeSumClosest(xs, a));

        xs = new ArrayList<>(ImmutableList.of(-1, -2, -3, -4));
        a = -3;
        assertEquals(-6, new Solution().threeSumClosest(xs, a));

    }
}
