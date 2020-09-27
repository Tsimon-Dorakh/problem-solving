package td.problemsolving.interviewbit.LongestArithmeticProgression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Longest Arithmetic Progression
 * https://www.interviewbit.com/problems/longest-arithmetic-progression/
 */
public class Solution {
    public int solve(final List<Integer> xs) {
        if (xs.size() <= 1) return 1;

        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        dp.put(xs.size() - 1, new HashMap<>());

        for (int l = xs.size() - 2; l >= 0; l--) {
            dp.put(l, new HashMap<>());

            for (int r = l + 1; r < xs.size(); r++) {
                int diff = xs.get(r) - xs.get(l);

                if (!dp.get(l).containsKey(diff)) {
                    dp.get(l).put(diff, 1 + dp.get(r).getOrDefault(diff, 0));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (Map<Integer, Integer> map : dp.values()) {
            for (Integer value : map.values()) {
                max = Math.max(max, value);
            }

        }

        return max + 1;
    }
}
