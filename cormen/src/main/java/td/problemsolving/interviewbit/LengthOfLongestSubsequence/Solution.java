package td.problemsolving.interviewbit.LengthOfLongestSubsequence;

import static td.problemsolving.utils.Print.print;

import java.util.ArrayList;
import java.util.List;

/**
 * Length of Longest Subsequence
 * https://www.interviewbit.com/problems/length-of-longest-subsequence/
 */
public class Solution {
    public int longestSubsequenceLength(final List<Integer> xs) {
        if (xs.size() == 0) return 0;

        Integer[] inc = new Integer[xs.size()];
        Integer[] dec = new Integer[xs.size()];

        increasingTo(inc, xs, xs.size() - 1);
        decreasingFrom(dec, xs, 0);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < inc.length; i++) {
            max = Math.max(max, inc[i] + dec[i] + 1);
        }

        return max;
    }

    int increasingTo(Integer[] dp, List<Integer> xs, int to) {
        if (dp[to] == null) {
            for (int r = to; r >= 0; r--) {
                if (dp[r] == null) {
                    dp[r] = 0;

                    for (int l = r - 1; l >= 0; l--) {
                        if (xs.get(r) > xs.get(l)) {
                            dp[r] = Math.max(dp[r], 1 + increasingTo(dp, xs, l));
                        }
                    }
                }
            }
        }

        return dp[to];
    }

    int decreasingFrom(Integer[] dp, List<Integer> xs, int from) {
        if (dp[from] == null) {
            for (int l = from; l < xs.size(); l++) {
                if (dp[l] == null) {
                    dp[l] = 0;

                    for (int r = l + 1; r < xs.size(); r++) {
                        if (xs.get(l) > xs.get(r)) {
                            dp[l] = Math.max(dp[l], 1 + decreasingFrom(dp, xs, r));
                        }
                    }
                }
            }
        }

        return dp[from];
    }
}
