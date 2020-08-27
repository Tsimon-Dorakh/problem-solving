package td.problemsolving.interviewbit.MaximumUnsortedSubarray;

import java.util.ArrayList;

/**
 * Maximum Unsorted Subarray
 * https://www.interviewbit.com/problems/maximum-unsorted-subarray/
 */
public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> xs) {
        ArrayList<Integer> result = new ArrayList<>();

        int max = getMax(xs);
        int min = getMin(xs);

        int l = 0;
        while (l < xs.size() - 1 && xs.get(l) <= xs.get(l + 1) && xs.get(l) >= min) {
            min = xs.get(l);
            l++;
        }

        if (l == xs.size() - 1) {
            result.add(-1);
            return result;
        }

        int r = xs.size() - 1;
        while (r > 0 && xs.get(r) >= xs.get(r - 1) && xs.get(r) <= max) {
            max = xs.get(r);
            r--;
        }

        max = getMax(xs, l, r);
        min = getMin(xs, l, r);

        while (r < xs.size() && xs.get(r) < max) r++;
        while (l >= 0 && xs.get(l) > min) l--;

        result.add(l + 1);
        result.add(r - 1);

        return result;
    }

    int getMax(ArrayList<Integer> xs) {
        return getMax(xs, 0, xs.size() - 1);
    }

    int getMax(ArrayList<Integer> xs, int l, int r) {
        int max = xs.get(l);

        for (int i = l + 1; i <= r; i++) {
            max = Math.max(max, xs.get(i));
        }

        return max;
    }

    int getMin(ArrayList<Integer> xs) {
        return getMin(xs, 0, xs.size() - 1);
    }

    int getMin(ArrayList<Integer> xs, int l, int r) {
        int min = xs.get(l);

        for (int i = l + 1; i <= r; i++) {
            min = Math.min(min, xs.get(i));
        }

        return min;
    }
}
