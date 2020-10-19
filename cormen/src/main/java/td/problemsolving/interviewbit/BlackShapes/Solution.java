package td.problemsolving.interviewbit.BlackShapes;

/**
 * Black Shapes
 * https://www.interviewbit.com/problems/black-shapes/
 */
public class Solution {
    public int black(String[] xs) {
        char[][] xss = new char[xs.length][];

        for (int i = 0; i < xs.length; i++) {
            xss[i] = xs[i].toCharArray();
        }

        int total = 0;

        for (int i = 0; i < xss.length; i++) {
            for (int j = 0; j < xss[i].length; j++) {
                if (xss[i][j] == 'X') {
                    mark(xss, i, j);
                    total++;
                }
            }
        }

        return total;
    }

    void mark(char[][] xss, int i, int j) {
        if (i < 0 || i >= xss.length) return;
        if (j < 0 || j >= xss[i].length) return;
        if (xss[i][j] == 'O') return;

        xss[i][j] = 'O';

        mark(xss, i + 1, j);
        mark(xss, i - 1, j);
        mark(xss, i, j + 1);
        mark(xss, i, j - 1);
    }
}
