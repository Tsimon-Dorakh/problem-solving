package td.problemsolving.interviewbit.JumpGameArray;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Jump Game Array
 * https://www.interviewbit.com/problems/jump-game-array/
 */
public class Solution {
    public int canJump(ArrayList<Integer> xs) {
        return canJumpI(xs) ? 1 : 0;
    }

    boolean canJumpI(ArrayList<Integer> xs) {
        Stack<Integer> stack = new Stack<>();
        boolean[] dp = new boolean[xs.size()];

        stack.push(0);

        while (!stack.isEmpty()) {
            Integer i = stack.pop();

            if (i == xs.size() - 1) return true;
            dp[i] = true;

            for (int j = i + 1; j <= i + xs.get(i) && j < xs.size(); j++) {
                if (!dp[j]) stack.push(j);
            }
        }

        return false;
    }

    boolean canJumpR(Boolean[] dp, ArrayList<Integer> xs, int from) {
        if (from == xs.size() - 1) return true;

        if (dp[from] == null) {
            dp[from] = false;

            for (int i = from + 1; i <= from + xs.get(from) && i < xs.size(); i++) {
                dp[from] |= canJumpR(dp, xs, i);
            }
        }

        return dp[from];
    }
}
