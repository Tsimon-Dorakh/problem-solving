package td.problemsolving.interviewbit.CaptureRegionsOnBoard;

import java.util.ArrayList;

/**
 * Capture Regions on Board
 * https://www.interviewbit.com/problems/capture-regions-on-board/
 */
public class Solution {
    public void solve(ArrayList<ArrayList<Character>> xss) {
        int n = xss.size();
        int m = xss.get(0).size();

        for (int i = 0; i < n; i++) {
            if (xss.get(i).get(0) == 'O') mark(xss, i, 0);
            if (xss.get(i).get(m - 1) == 'O') mark(xss, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            if (xss.get(0).get(j) == 'O') mark(xss, 0, j);
            if (xss.get(n - 1).get(j) == 'O') mark(xss, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Character x = xss.get(i).get(j);

                xss.get(i).set(j, x == 'N' ? 'O' : 'X');
            }
        }
    }

    void mark(ArrayList<ArrayList<Character>> xss, int i, int j) {
        if (i < 0 || i >= xss.size()) return;
        if (j < 0 || j >= xss.get(i).size()) return;
        if (xss.get(i).get(j) != 'O') return;

        xss.get(i).set(j, 'N');

        mark(xss, i + 1, j);
        mark(xss, i - 1, j);
        mark(xss, i, j + 1);
        mark(xss, i, j - 1);
    }
}
