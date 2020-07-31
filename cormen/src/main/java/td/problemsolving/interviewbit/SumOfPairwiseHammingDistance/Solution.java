package td.problemsolving.interviewbit.SumOfPairwiseHammingDistance;

import java.util.List;

/**
 * Sum of pairwise Hamming Distance
 * https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
 */
public class Solution {
    public int hammingDistance(final List<Integer> xs) {
        int mod = 1000000007;
        int result = 0;

        for (int i = 0; i < 31; i++) {
            int bits = 0;
            for (Integer x : xs) {
                if ((x & (1 << i)) > 0) bits++;
            }

            result += (2L * bits * (xs.size() - bits)) % mod;
            result %= mod;

        }

        return result;
    }
}
