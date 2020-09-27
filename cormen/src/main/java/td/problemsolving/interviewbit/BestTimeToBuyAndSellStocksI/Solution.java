package td.problemsolving.interviewbit.BestTimeToBuyAndSellStocksI;

import java.util.List;

/**
 * Best Time to Buy and Sell Stocks I
 * https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
 */
public class Solution {
    public int maxProfit(final List<Integer> xs) {
        if (xs.size() == 0) return 0;

        int[] buy = new int[xs.size()];
        int[] sell = new int[xs.size()];

        buy[0] = xs.get(0);
        for (int i = 1; i < xs.size(); i++) {
            buy[i] = Math.min(xs.get(i), buy[i - 1]);
        }

        sell[sell.length - 1] = xs.get(xs.size() - 1);
        for (int i = xs.size() - 2; i >= 0; i--) {
            sell[i] = Math.max(xs.get(i), sell[i + 1]);
        }

        int max = sell[0] - buy[0];
        for (int i = 1; i < sell.length; i++) {
            max = Math.max(max, sell[i] - buy[i]);
        }

        return max;
    }
}
