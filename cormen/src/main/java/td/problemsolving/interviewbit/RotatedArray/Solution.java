package td.problemsolving.interviewbit.RotatedArray;

import java.util.List;

/**
 * Rotated Array
 * https://www.interviewbit.com/problems/rotated-array/
 */
public class Solution {
    public int findMin(final List<Integer> xs) {
        int l = 0;
        int r = xs.size() - 1;

        while (l <= r) {
            if (xs.get(l) <= xs.get(r)) {
                return xs.get(l);
            }

            int m = (l + r) / 2;
            int prev = (m + xs.size() - 1) % xs.size();
            int next = (m + 1) % xs.size();

            if (xs.get(m) < xs.get(prev) && xs.get(m) < xs.get(next)) {
                return xs.get(m);
            }

            if (xs.get(m) >= xs.get(0)) l = m + 1;
            else r = m - 1;
        }

        return 0;
    }
}
