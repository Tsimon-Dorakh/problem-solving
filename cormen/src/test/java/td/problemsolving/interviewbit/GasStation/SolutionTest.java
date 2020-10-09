package td.problemsolving.interviewbit.GasStation;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void canCompleteCircuit() {
        List<Integer> xs;
        List<Integer> ys;
        int expected;

        xs = ImmutableList.of(1, 2);
        ys = ImmutableList.of(2, 1);
        expected = 1;
        assertEquals(expected, new Solution().canCompleteCircuit(xs, ys));
    }
}
