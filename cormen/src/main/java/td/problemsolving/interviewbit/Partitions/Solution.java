package td.problemsolving.interviewbit.Partitions;

import java.util.ArrayList;

/**
 * Partitions
 * https://www.interviewbit.com/problems/partitions/
 */
public class Solution {
    public int solve(int l, ArrayList<Integer> xs) {
        int sum = 0;
        int result = 0;

        int[] c = new int[xs.size()];

        for (Integer x : xs) {
            sum += x;
        }

        if (sum % 3 != 0) return 0;

        int part = sum / 3;

        sum = xs.get(c.length - 1);
        c[c.length - 1] = (xs.get(c.length - 1) == part) ? 1 : 0;
        for (int i = c.length - 2; i > 1; i--) {
            sum += xs.get(i);
            if (sum == part) {
                c[i] = c[i + 1] + 1;
            } else {
                c[i] = c[i + 1];
            }
        }

        sum = 0;
        for (int i = 0; i < xs.size() - 2; i++) {
            sum += xs.get(i);
            if (sum == part) {
                result += c[i + 2];
            }
        }


        return result;
    }
}
