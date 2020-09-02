package td.problemsolving.interviewbit.NUMRANGE;

import java.util.ArrayList;

/**
 * NUMRANGE
 * https://www.interviewbit.com/problems/numrange/
 */
public class Solution {
    public int numRange(ArrayList<Integer> xs, int a, int b) {
        return OnSolution(xs, a, b);
    }

    int OnSolution(ArrayList<Integer> xs, int a, int b) {
        return OnSolution(xs, a, b, 0, xs.size() - 1);
    }

    int OnSolution(ArrayList<Integer> xs, int a, int b, int from, int to) {
        if (from > to) return 0;

        int l = from;
        int r = from - 1;
        int result = 0;
        int sum = 0;

        while (r < to) {
            r++;
            sum += xs.get(r);

            if (isIn(a, b, sum)) {
                result++;
            } else if (isMore(a, b, sum)) {
                r = l;
                l++;
                sum = 0;
            }
        }

        result += OnSolution(xs, a, b, l + 1, to);

        return result;
    }

    int On2Solution(ArrayList<Integer> xs, int a, int b) {
        int count = 0;

        for (int i = 0; i < xs.size(); i++) {
            for (int j = i; j < xs.size(); j++) {
                int sum = 0;

                for (int k = i; k <= j; k++) sum += xs.get(k);

                if (isIn(a, b, sum)) count++;
            }
        }

        return count;
    }

    boolean isIn(int a, int b, int x) {
        return a <= x && x <= b;
    }

    boolean isMore(int a, int b, int x) {
        return x > b;
    }
}
