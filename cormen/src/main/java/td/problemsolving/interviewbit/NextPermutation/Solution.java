package td.problemsolving.interviewbit.NextPermutation;

import java.util.ArrayList;

/**
 * Next Permutation
 * https://www.interviewbit.com/problems/next-permutation/
 */
public class Solution {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> xs) {
        if (isSortedDescending(xs) || xs.size() < 2) {
            return revert(xs, 0, xs.size() - 1);
        }

        int i = xs.size() - 2;
        while (xs.get(i) > xs.get(i + 1)) i--;

        int j = xs.size() - 1;
        while (xs.get(i) > xs.get(j)) j--;

        swap(xs, i, j);

        return revert(xs, i + 1, xs.size() - 1);
    }

    private void swap(ArrayList<Integer> xs, int i, int j) {
        int tmp = xs.get(i);
        xs.set(i, xs.get(j));
        xs.set(j, tmp);
    }

    private ArrayList<Integer> revert(ArrayList<Integer> xs, int l, int r) {
        for (int i = 0; i < (r - l + 1) / 2; i++) {
            int tmp = xs.get(l + i);
            xs.set(l + i, xs.get(r - i));
            xs.set(r - i, tmp);
        }

        return xs;
    }

    private boolean isSortedDescending(ArrayList<Integer> xs) {
        for (int i = 0; i < xs.size() - 1; i++) {
            if (xs.get(i) < xs.get(i + 1)) return false;
        }

        return true;
    }
}
