package td.problemsolving.interviewbit.RainWaterTrapped;

import java.util.List;

/**
 * Rain Water Trapped
 * https://www.interviewbit.com/problems/rain-water-trapped/
 */
public class Solution {
    public int trap(final List<Integer> xs) {
        int[] fill = new int[xs.size()];
        int prev_max = 0;
        for (int i = 0; i < xs.size(); i++) {
            fill[i] = Math.max(0, prev_max - xs.get(i));
            prev_max = Math.max(prev_max, xs.get(i));
        }

        prev_max = 0;
        for (int i = xs.size() - 1; i >= 0; i--) {
            fill[i] = Math.min(fill[i], prev_max - xs.get(i));
            fill[i] = Math.max(0, fill[i]);
            prev_max = Math.max(prev_max, xs.get(i));
        }

        int sum = 0;
        for (int x : fill) {
            sum += x;
        }

        return sum;
    }
}
