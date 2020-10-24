package td.problemsolving.hackerrank.CountTriplets;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void countTriplets() {
        List<Long> xs;
        long r;
        long expected;

        xs = ImmutableList.of(1L, 2L, 2L, 4L);
        r = 2;
        expected = 2;
        assertEquals(expected, Solution.countTriplets(xs, r));

    }
}
