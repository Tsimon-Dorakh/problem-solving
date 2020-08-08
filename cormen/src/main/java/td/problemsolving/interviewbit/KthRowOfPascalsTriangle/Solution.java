package td.problemsolving.interviewbit.KthRowOfPascalsTriangle;

import java.util.ArrayList;

/**
 * Kth Row of Pascal's Triangle
 * https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
 */
public class Solution {
    public ArrayList<Integer> getRow(int k) {
        return math(k);
    }

    public ArrayList<Integer> math(int k) {
        ArrayList<Integer> row = new ArrayList<>();

        int n = 1;
        for (int col = 0; col <= k; col++) {
            row.add(n);
            n = n * (k - col) / (col + 1);
        }

        return row;
    }

    public ArrayList<Integer> simple(int k) {
        ArrayList<Integer> row = new ArrayList<>();

        row.add(1);

        for (int i = 1; i <= k; i++) {
            ArrayList<Integer> prevRow = row;
            row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);
        }

        return row;
    }
}
