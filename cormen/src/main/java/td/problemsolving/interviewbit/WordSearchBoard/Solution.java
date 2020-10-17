package td.problemsolving.interviewbit.WordSearchBoard;

import java.util.ArrayList;

/**
 * Word Search Board
 * https://www.interviewbit.com/problems/word-search-board/
 */
public class Solution {
    public int exist(ArrayList<String> inputBoard, String s) {
        char[][] xss = new char[inputBoard.size()][inputBoard.get(0).length()];

        for (int i = 0; i < inputBoard.size(); i++) {
            xss[i] = inputBoard.get(i).toCharArray();
        }

        for (int i = 0; i < xss.length; i++) {
            for (int j = 0; j < xss[i].length; j++) {
                if (xss[i][j] == s.charAt(0) && possible(xss, s, i, j, 0)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    boolean possible(char[][] xss, String s, int i, int j, int k) {
        if (k == s.length()) return true;
        if (i < 0 || j < 0 || i == xss.length || j == xss[0].length) return false;
        if (xss[i][j] != s.charAt(k)) return false;

        return
                possible(xss, s, i + 1, j, k + 1) ||
                possible(xss, s, i - 1, j, k + 1) ||
                possible(xss, s, i, j + 1, k + 1) ||
                possible(xss, s, i, j - 1, k + 1);

    }
}
