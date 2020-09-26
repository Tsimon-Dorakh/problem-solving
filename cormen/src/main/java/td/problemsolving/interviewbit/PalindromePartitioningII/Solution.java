package td.problemsolving.interviewbit.PalindromePartitioningII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Palindrome Partitioning II
 * https://www.interviewbit.com/problems/palindrome-partitioning-ii/
 */
public class Solution {
    public int minCut(String s) {
        return minCut(new Integer[s.length()], s, 0, s.length() - 1);
    }

    public int minCut(Integer[] dp, String s, int start, int end) {
        if (start > end) return 0;
        if (isPalindrome(s, start, end)) return 0;

        if (dp[start] == null) {
            int min = Integer.MAX_VALUE;
            int r = start;

            while (r <= end) {
                if (isPalindrome(s, start, r)) {
                    min = Math.min(min, 1 + minCut(dp, s, r + 1, end));
                }

                r++;
            }

            dp[start] = min;
        }

        return dp[start];
    }

    boolean isPalindrome(String s, int start, int end) {
        int l = start;

        while (l < (start + end + 1) / 2) {
            if (s.charAt(l) != s.charAt(end - (l - start))) return false;

            l++;
        }

        return true;
    }
}
