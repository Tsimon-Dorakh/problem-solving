package td.problemsolving.interviewbit.MinStepsInInfiniteGrid;

import java.util.List;

/**
 * Min Steps in Infinite Grid
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
public class Solution {
    public int coverPoints(List<Integer> xs, List<Integer> ys) {
        int count = 0;

        for (int i = 1; i < xs.size(); i++) {
            int dx = Math.abs(xs.get(i) - xs.get(i - 1));
            int dy = Math.abs(ys.get(i) - ys.get(i - 1));

            count += Math.max(dx, dy);
        }

        return count;
    }
}
