package td.problemsolving.interviewbit.WordBreak;

import java.util.ArrayList;

/**
 * Word Break
 * https://www.interviewbit.com/problems/word-break/
 */
public class Solution {
    public int wordBreak(String s, ArrayList<String> xs) {
        return wordBreakBool(new Boolean[s.length()], s, xs, 0) ? 1 : 0;
    }

    boolean wordBreakBool(Boolean[] dp, String s, ArrayList<String> xs, int l) {
        if (l >= s.length()) return true;

        if (dp[l] == null) {
            int r = l + 1;
            boolean result = false;
            while (r <= s.length() && r - l <= 20) {
                String sub = s.substring(l, r);

                if (xs.contains(sub)) {
                    result = result || wordBreakBool(dp, s, xs, r);
                }

                r++;
            }

            dp[l] = result;
        }

        return dp[l];
    }
}
