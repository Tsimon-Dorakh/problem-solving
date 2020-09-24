package td.problemsolving.interviewbit.BestTimeToBuyAndSellStocksII;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProfit() {
        List<Integer> xs;
        int expected;

        xs = ImmutableList.of(0, 5, 5, 6);
        expected = 6;
        assertEquals(expected, new Solution().maxProfit(xs));

        xs = ImmutableList.of(3, 3, 4);
        expected = 1;
        assertEquals(expected, new Solution().maxProfit(xs));

        xs = ImmutableList.of(0, 1);
        expected = 1;
        assertEquals(expected, new Solution().maxProfit(xs));

        xs = ImmutableList.of(1, 2, 3);
        expected = 2;
        assertEquals(expected, new Solution().maxProfit(xs));

        xs = ImmutableList.of(5, 2, 10);
        expected = 8;
        assertEquals(expected, new Solution().maxProfit(xs));
    }
}
