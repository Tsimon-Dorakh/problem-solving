package td.problemsolving.interviewbit.OrderOfPeopleHeights;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void order() {
        ArrayList<Integer> xs;
        ArrayList<Integer> ys;
        ArrayList<Integer> expected;

        xs = new ArrayList<>(ImmutableList.of(5, 3, 2, 6, 1, 4));
        ys = new ArrayList<>(ImmutableList.of(0, 1, 2, 0, 3, 2));
        expected = new ArrayList<>(ImmutableList.of(5, 3, 2, 1, 6, 4));
        assertEquals(expected, new Solution().order(xs, ys));
    }
}
