package td.problemsolving.interviewbit.LongestCommonSubsequence;

import java.util.Arrays;

/**
 * Longest Common Subsequence
 * https://www.interviewbit.com/problems/longest-common-subsequence/
 */
public class Solution {
    public int solve(String x, String y) {
        char[] xs = x.toCharArray();
        char[] ys = y.toCharArray();
        int[][] buff = new int[xs.length][];
        for (int i = 0; i < buff.length; i++) {
            buff[i] = new int[ys.length];

            Arrays.fill(buff[i], -1);
        }

        return longest(buff, xs, ys, 0, 0);
    }

    int longest(int[][] buff, char[] xs, char[] ys, int i, int j) {
        if (i >= xs.length) return 0;
        if (j >= ys.length) return 0;

        if (buff[i][j] == -1) {
            if (xs[i] == ys[j]) {
                buff[i][j] = 1 + longest(buff, xs, ys, i + 1, j + 1);
            } else {
                buff[i][j] = Math.max(longest(buff, xs, ys, i + 1, j), longest(buff, xs, ys, i, j + 1));
            }
        }

        return buff[i][j];
    }
}
