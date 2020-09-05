package td.problemsolving.interviewbit.NQueens;

import java.util.ArrayList;

/**
 * NQueens
 * https://www.interviewbit.com/problems/nqueens/
 */
public class Solution {
    ArrayList<ArrayList<String>> solutions = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        int[][] field = createField(a);

        findSolutions(field, 0);

        return solutions;
    }

    void findSolutions(int[][] field, int row) {
        for (int j = 0; j < field.length; j++) {
            if (isValidPosition(field, row, j)) {
                field[row][j] = 1;

                if (row == field.length - 1) {
                    solutions.add(createSolution(field));
                } else {
                    findSolutions(field, row + 1);
                }

                field[row][j] = 0;
            }
        }
    }

    ArrayList<String> createSolution(int[][] field) {
        ArrayList<String> xs = new ArrayList<>();

        for (int[] row : field) {
            StringBuilder s = new StringBuilder();

            for (int x : row) {
                if (x == 1) s.append('Q');
                else s.append('.');
            }

            xs.add(s.toString());
        }

        return xs;
    }

    boolean isValidPosition(int[][] field, int i, int j) {
         int k;
         int l;

        for (k = i - 1; k >= 0; k--) {
            if (field[k][j] == 1) return false;
        }

         for (k = j - 1; k >= 0; k--) {
             if (field[i][k] == 1) return false;
         }

         k = i - 1;
         l = j - 1;
         while (k >= 0 && l >= 0) {
             if (field[k--][l--] == 1) return false;
         }

         k = i - 1;
         l = j + 1;
         while (k >= 0 && l < field.length) {
             if (field[k--][l++] == 1) return false;
         }

        return true;
     }

    int[][] createField(int a) {
        int[][] field = new int[a][];

        for (int i = 0; i < a; i++) {
            field[i] = new int[a];
        }

        return field;
    }
}
