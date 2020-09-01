package td.problemsolving.interviewbit.RotatedSortedArraySearch;

import java.util.List;

/**
 * Rotated Sorted Array Search
 * https://www.interviewbit.com/problems/rotated-sorted-array-search/
 */
public class Solution {
    public int search(final List<Integer> xs, int x) {
        int pivot = findPivot(xs);

        if (pivot == 0) {
            return binary(xs, 0, xs.size() - 1, x);
        } else {
            if (x >= xs.get(0)) return binary(xs, 0, pivot - 1, x);
            else return binary(xs, pivot, xs.size() - 1, x);
        }
    }

    int binary(final List<Integer> xs, int l, int r, int x) {
        while (l <= r) {
            int m = (l + r) / 2;

            if (xs.get(m) < x) l = m + 1;
            else if (xs.get(m) > x) r = m - 1;
            else return m;
        }

        return -1;
    }

    int findPivot(final List<Integer> xs) {
        if (xs.get(0) < xs.get(xs.size() - 1)) return 0;

        int l = 0;
        int r = xs.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            int prev = (m + xs.size() - 1) % xs.size();
            int next = (m + xs.size() + 1) % xs.size();
            if (xs.get(prev) > xs.get(m) && xs.get(next) > xs.get(m)) return m;
            else if (xs.get(m) > xs.get(0)) l = m + 1;
            else r = m - 1;
        }

        throw new RuntimeException("Unsupported case");
    }
}
