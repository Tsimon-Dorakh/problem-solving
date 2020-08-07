package td.problemsolving.interviewbit.FirstMissingInteger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * First Missing Integer
 * https://www.interviewbit.com/problems/first-missing-integer/
 */
public class Solution {
    public int firstMissingPositive(ArrayList<Integer> xs) {
        return nSolution(xs);
    }

    private int nSolution(ArrayList<Integer> xs) {
        for (int i = 0; i < xs.size(); i++) {
            int num = xs.get(i);
            int pos = num - 1;

            if (pos >= 0 && pos < xs.size() && xs.get(pos) != num) {
                xs.set(i, xs.get(pos));
                xs.set(pos, num);
                i--;
            }
        }

        for (int i = 0; i < xs.size(); i++) {
            if (xs.get(i) != i + 1) return i + 1;
        }

        return xs.size() + 1;
    }

    private int nLogNSolution(ArrayList<Integer> xs) {
        Collections.sort(xs);

        int expected = 1;

        for (Integer x : xs) {
            if (x == expected) expected++;
        }

        return expected;
    }
}
