package td.problemsolving.interviewbit.BestTimeToBuyAndSellStocksI;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProfit() {
        List<Integer> xs;
        int expected;

        xs = ImmutableList.of(1, 2);
        expected = 1;
        assertEquals(expected, new Solution().maxProfit(xs));

        xs = ImmutableList.of(1, 4, 5, 2, 4);
        expected = 4;
        assertEquals(expected, new Solution().maxProfit(xs));
    }
}
