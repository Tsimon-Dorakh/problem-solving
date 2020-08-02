package td.problemsolving.interviewbit.MaxSumContiguousSubarray;

import java.util.List;

/**
 * Max Sum Contiguous Subarray
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 */
public class Solution {
    public int maxSubArray(final List<Integer> xs) {
        return kadaneAlgo(xs);
    }

    public int kadaneAlgo(final List<Integer> xs) {
        int max = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE / 2;

        for (Integer x : xs) {
            if (x > prev + x) {
                prev = x;
            } else {
                prev += x;
            }

            max = Math.max(max, prev);
        }

        return max;
    }

    public int bruteForce(final List<Integer> xs) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < xs.size(); i++) {
            int sum = xs.get(i);

            for (int j = i + 1; j < xs.size(); j++) {
                sum += xs.get(j);

                max = Math.max(max, sum);
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
