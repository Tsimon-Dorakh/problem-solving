package td.problemsolving.interviewbit.PascalTriangle;

import java.util.ArrayList;

/**
 * Pascal Triangle
 * https://www.interviewbit.com/problems/pascal-triangle/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int x) {
        ArrayList<ArrayList<Integer>> xss = new ArrayList<>();

        if (x == 0) return xss;

        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        xss.add(row);

        for (int i = 1; i < x; i++) {
            row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(xss.get(i - 1).get(j - 1) + xss.get(i - 1).get(j));
            }

            row.add(1);
            xss.add(row);
        }

        return xss;
    }
}
