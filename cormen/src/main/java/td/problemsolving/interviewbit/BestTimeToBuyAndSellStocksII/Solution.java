package td.problemsolving.interviewbit.BestTimeToBuyAndSellStocksII;

import java.util.List;

/**
 * Best Time to Buy and Sell Stocks II
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
 */
public class Solution {
    public int maxProfit(final List<Integer> xs) {
        int result = 0;

        for (int i = 0; i < xs.size() - 1; i++) {
            if (xs.get(i) < xs.get(i + 1)) {
                result += xs.get(i + 1) - xs.get(i);
            }
        }

        return result;
    }
}
