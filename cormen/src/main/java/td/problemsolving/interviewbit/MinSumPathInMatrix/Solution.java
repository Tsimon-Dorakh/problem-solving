package td.problemsolving.interviewbit.MinSumPathInMatrix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Min Sum Path in Matrix
 * https://www.interviewbit.com/problems/min-sum-path-in-matrix/
 */
public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> xss) {
        int[][] dp = new int[xss.size()][];
        for (int i = 0; i < xss.size(); i++) {
            dp[i] = new int[xss.get(0).size()];
            Arrays.fill(dp[i], -1);
        }

        return minPathSum(dp, xss, 0, 0);
    }

    int minPathSum(int[][] dp, ArrayList<ArrayList<Integer>> xss, int i, int j) {
        if (i == xss.size()) return 0;
        if (j == xss.get(i).size()) return 0;

        if (dp[i][j] == -1) {
            if (i == xss.size() - 1) {
                dp[i][j] = xss.get(i).get(j) + minPathSum(dp, xss, i, j + 1);
            } else if (j == xss.get(i).size() - 1) {
                dp[i][j] = xss.get(i).get(j) + minPathSum(dp, xss, i + 1, j);
            } else {
                dp[i][j] = xss.get(i).get(j) + Math.min(minPathSum(dp, xss, i + 1, j), minPathSum(dp, xss, i, j + 1));
            }

        }

        return dp[i][j];
    }
}
