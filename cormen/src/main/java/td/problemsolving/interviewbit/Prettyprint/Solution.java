package td.problemsolving.interviewbit.Prettyprint;

import java.util.ArrayList;

/**
 * Prettyprint
 * https://www.interviewbit.com/problems/prettyprint/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < 2 * n - 1; i++) {
            result.add(new ArrayList<>(2 * n - 1));
        }

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                result.get(i).add(Math.max(Math.abs((n - 1) - i), Math.abs((n - 1) - j)) + 1);
            }
        }

        return result;
    }
}
