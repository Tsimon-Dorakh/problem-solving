package td.problemsolving.interviewbit.KthPermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Kth Permutation Sequence
     * https://www.interviewbit.com/problems/kth-permutation-sequence/
     */
    public String getPermutation(int n, int k) {
        List<String> xs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            xs.add(String.valueOf(i));
        }

        return getNextPermutation(xs, k - 1);
    }

    String getNextPermutation(List<String> xs, int pos) {
        if (xs.size() == 0) return "";

        int idx = pos / factorial(xs.size() - 1);
        String result = xs.get(idx);
        xs.remove(idx);

        result += getNextPermutation(xs, pos % factorial(xs.size()));

        return result;
    }

    int factorial(int x) {
        if (x > 12) return Integer.MAX_VALUE;

        int result = 1;

        while (x > 1) {
            result *= x--;
        }

        return result;
    }
}
