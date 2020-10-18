package td.problemsolving.interviewbit.SmallestMultipleWith0And1;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Smallest Multiple With 0 and 1
 * https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
 */
public class Solution {
    public String multiple(int a) {
        return bfsSolution(a);
    }

    String bfsSolution(int a) {
        if (a == 1) return "1";

        String[] dp = new String[a];
        dp[1] = "1";

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int r = queue.poll();

            if (r == 0) {
                return dp[r];
            } else {
                for (int digit = 0; digit <= 1; digit++) {
                    int new_r = (10 * r + digit) % a;
                    if (dp[new_r] == null) {
                        queue.add(new_r);
                        dp[new_r] = dp[r] + digit;
                    }
                }
            }
        }

        throw new RuntimeException("Impossible");
    }

    String whileSolution(int a) {
        int n = 1;

        while (true) {
            BigInteger bigInteger = new BigInteger(Integer.toBinaryString(n));
            if (bigInteger.mod(BigInteger.valueOf(a)).equals(BigInteger.ZERO)) {
                return bigInteger.toString();
            }
            n++;
        }
    }
}
