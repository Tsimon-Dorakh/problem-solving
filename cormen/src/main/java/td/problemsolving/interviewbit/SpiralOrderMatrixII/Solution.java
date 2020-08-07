package td.problemsolving.interviewbit.SpiralOrderMatrixII;

import java.util.ArrayList;

/**
 * Spiral Order Matrix II
 * https://www.interviewbit.com/problems/spiral-order-matrix-ii/
 */
public class Solution {
    int x = 0;
    int y = 0;
    int d = 1;
    int level = 0;

    private void nextStep(int n) {
        if (d == 1) {
            if (x + 1 <= n - level - 1) x++;
            else {
                d = 2;
                y++;
            }
        } else if (d == 2) {
            if (y + 1 <= n - level - 1) y++;
            else {
                d = 3;
                x--;
            }
        } else if (d == 3) {
            if (x > level) x--;
            else {
                d = 4;
                y--;
            }
        } else {
            if (y > level + 1) y--;
            else {
                d = 1;
                x++;
                level++;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        int[][] xss = new int[n][];

        for (int i = 0; i < xss.length; i++) {
            xss[i] = new int[n];
        }

        for (int i = 1; i <= n * n; i++) {
            xss[y][x] = i;
            nextStep(n);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < xss.length; i++) {
            result.add(new ArrayList<>());

            for (int j = 0; j < xss[i].length; j++) {
                result.get(i).add(xss[i][j]);
            }
        }

        return result;
    }
}
