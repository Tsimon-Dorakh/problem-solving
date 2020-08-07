package td.problemsolving.interviewbit.SetMatrixZeros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Set Matrix Zeros
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 */
public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> xss) {
        NPlusMSolution(xss);
    }

    private void NPlusMSolution(ArrayList<ArrayList<Integer>> xss) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < xss.size(); i++) {
            for (int j = 0; j < xss.get(i).size(); j++) {
                if (xss.get(i).get(j) == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < xss.size(); i++) {
            for (int j = 0; j < xss.get(i).size(); j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    xss.get(i).set(j, 0);
                }
            }
        }
    }
}
