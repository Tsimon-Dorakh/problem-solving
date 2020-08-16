package td.problemsolving.interviewbit.MaximumConsecutiveGap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maximum Consecutive Gap
 * https://www.interviewbit.com/problems/maximum-consecutive-gap/
 */
public class Solution {
    public int maximumGap(final List<Integer> xs) {
        return nSolution(xs);
    }

    public int nSolution(final List<Integer> xs) {
        if (xs.size() < 2) return 0;

        int min = getMin(xs);
        int max = getMax(xs);
        double gap = (max - min) / (xs.size() - 1.);

        if (gap == 0) return 0;

        int bucketCount = (int)Math.ceil((max - min + 1.0) / gap);
        int[] minBuckets = new int[bucketCount];
        int[] maxBuckets = new int[bucketCount];

        for (int i = 0; i < minBuckets.length; i++) {
            minBuckets[i] = Integer.MAX_VALUE;
            maxBuckets[i] = Integer.MIN_VALUE;
        }

        for (Integer x : xs) {
            int i = (int) ((x - min) / gap);
            minBuckets[i] = Math.min(minBuckets[i], x);
            maxBuckets[i] = Math.max(maxBuckets[i], x);
        }

        int i = 0;
        int prevMax = maxBuckets[i];
        while (prevMax == Integer.MIN_VALUE) prevMax = maxBuckets[++i];
        int maxDiff = prevMax - min;

        for (i += 1; i < minBuckets.length; i++) {
            if (minBuckets[i] == Integer.MAX_VALUE) continue;

            maxDiff = Math.max(maxDiff, minBuckets[i] - prevMax);
            prevMax = maxBuckets[i];
        }

        return maxDiff;
    }

    public int nLogNSolution(final List<Integer> xs) {
        if (xs.size() < 2) return 0;

        int max = 0;
        List<Integer> ys = new ArrayList<>(xs);

        Collections.sort(ys);

        for (int i = 1; i < ys.size(); i++) {
            max = Math.max(max, ys.get(i) - ys.get(i - 1));
        }

        return max;
    }

    private int getMin(final List<Integer> xs) {
        int min = xs.get(0);

        for (Integer x : xs) {
            min = Math.min(min, x);
        }

        return min;
    }

    private int getMax(final List<Integer> xs) {
        int max = xs.get(0);

        for (Integer x : xs) {
            max = Math.max(max, x);
        }

        return max;
    }
}
