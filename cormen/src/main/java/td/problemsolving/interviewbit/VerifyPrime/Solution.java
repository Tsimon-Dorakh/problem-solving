package td.problemsolving.interviewbit.VerifyPrime;

/**
 * Verify Prime
 * https://www.interviewbit.com/problems/verify-prime/
 */
public class Solution {
    public int isPrime(int x) {
        if (x == 1) return 0;
        if (x <= 3) return 1;

        for (int i = 2; i <= (int)Math.sqrt(x); i++) {
            if (x % i == 0) return 0;
        }

        return 1;
    }
}
