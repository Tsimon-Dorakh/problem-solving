package td.problemsolving.interviewbit.RotatedArray;

import java.util.List;

/**
 * Rotated Array
 * https://www.interviewbit.com/problems/rotated-array/
 */
public class Solution {
    public int findMin(final List<Integer> xs) {
        if (xs.get(0) < xs.get(xs.size() - 1)) return xs.get(0);

        int l = 0;
        int r = xs.size();

        while (l <= r) {
            int m = (l + r) / 2;

            if (xs.get(m) > xs.get(0)) l = m + 1;
            else r = m - 1;
        }

        if (l >= xs.size()) return xs.get(r);
        if (r < 0) return xs.get(l);

        return Math.min(xs.get(l), xs.get(r));
    }
}
