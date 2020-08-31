package td.problemsolving.interviewbit.LongestCommonPrefix;

import java.util.ArrayList;

/**
 * Longest Common Prefix
 * https://www.interviewbit.com/problems/longest-common-prefix/
 */
public class Solution {
    public String longestCommonPrefix(ArrayList<String> xs) {
        String longest = "";
        if (xs.size() == 0) return longest;

        int longestStringLength = getLongestStringLength(xs);

        for (int i = 0; i < longestStringLength; i++) {
            if (xs.get(0).length() == i) return longest;

            String current = longest + xs.get(0).substring(i, i + 1);
            for (String x : xs) {
                if (!x.startsWith(current))
                    return longest;
            }

            longest = current;
        }

        return longest;
    }

    private int getLongestStringLength(ArrayList<String> xs) {
        int longest = 0;

        for (String x : xs) {
            longest = Math.max(longest, x.length());
        }

        return longest;
    }
}
