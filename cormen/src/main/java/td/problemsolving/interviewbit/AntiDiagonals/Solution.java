package td.problemsolving.interviewbit.AntiDiagonals;

import java.util.ArrayList;

/**
 * Anti Diagonals
 * https://www.interviewbit.com/problems/anti-diagonals/
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> xss) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(2 * xss.size() - 1);

        for (int k = 0; k < 2 * xss.size() - 1; k++) {
            ArrayList<Integer> row = new ArrayList<>();

            int i = Math.max(0, k - (xss.size() - 1));
            int j = k - i;
            int c = xss.size() - Math.abs(k - xss.size() + 1);

            for (int l = 0; l < c; l++) {
                row.add(xss.get(i).get(j));
                i++;
                j--;
            }

            result.add(row);
        }

        return result;
    }
}
