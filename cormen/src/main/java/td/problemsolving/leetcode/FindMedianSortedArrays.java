package td.problemsolving.leetcode;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] xs, int[] ys) {
        return bruteForce(xs, ys);
    }

    private double bruteForce(int[] xs, int[] ys) {
        int[] zs = new int[xs.length + ys.length];

        int i = 0;

        for (int x : xs) {
            zs[i++] = x;
        }

        for (int y : ys) {
            zs[i++] = y;
        }

        Arrays.sort(zs);

        if (zs.length % 2 == 0) {
            return (zs[zs.length / 2 - 1] + zs[zs.length / 2]) / 2.;
        } else {
            return zs[zs.length / 2];
        }
    }
}
