package td.problemsolving.interviewbit.MaximumAbsoluteDifference;

import java.util.ArrayList;

/**
 * Maximum Absolute Difference
 * https://www.interviewbit.com/problems/maximum-absolute-difference/
 */
public class Solution {
    public int maxArr(ArrayList<Integer> xs) {
        return expandSolution(xs);
    }

    public int expandSolution(ArrayList<Integer> xs) {
        int max1 = Integer.MIN_VALUE,
            max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE,
            min2 = Integer.MAX_VALUE;

        for (int i = 0; i < xs.size(); i++){
            max1 = Math.max(max1, xs.get(i) + i);
            max2 = Math.max(max2, xs.get(i) - i);

            min1 = Math.min(min1, xs.get(i) + i);
            min2 = Math.min(min2, xs.get(i) - i);
        }

        return Math.max(max1 - min1, max2 - min2);
    }

    public int bruteForce(ArrayList<Integer> xs) {
        int max = 0;

        for (int i = 0; i < xs.size(); i++) {
            for (int j = 0; j < xs.size(); j++) {
                max = Math.max(max, Math.abs(xs.get(i) - xs.get(j)) + Math.abs(i - j));
            }
        }

        return max;
    }
}
