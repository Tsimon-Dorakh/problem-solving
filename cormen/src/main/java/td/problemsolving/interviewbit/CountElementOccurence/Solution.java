package td.problemsolving.interviewbit.CountElementOccurence;

import java.util.List;

/**
 * Count Element Occurence
 * https://www.interviewbit.com/problems/count-element-occurence/
 */
public class Solution {
    public int findCount(final List<Integer> xs, int x) {
        int l = findFirst(xs, x);

        if (l == -1) return 0;

        int r = findLast(xs, x);

        return r - l + 1;
    }

    int findFirst(final List<Integer> xs, int x) {
        int l = 0;
        int r = xs.size() - 1;
        int result = -1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (xs.get(m) == x) {
                result = m;
                r = m - 1;
            } else if (xs.get(m) < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }

    int findLast(final List<Integer> xs, int x) {
        int l = 0;
        int r = xs.size() - 1;
        int result = -1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (xs.get(m) == x) {
                result = m;
                l = m + 1;
            } else if (xs.get(m) < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }

}
