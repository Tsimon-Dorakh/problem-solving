package td.problemsolving.interviewbit.RotateMatrix;

import java.util.ArrayList;

/**
 * Rotate Matrix
 * https://www.interviewbit.com/problems/rotate-matrix/
 */
public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> xss) {
//        additionalSpaceSolution(xss);
        inPlaceSolution(xss);
    }

    public void inPlaceSolution(ArrayList<ArrayList<Integer>> xss) {
        int n = xss.size();
        int level = 0;

        while (level <= (n - 1) / 2) {
            for (int x = level; x < n - level - 1; x++) {
                int x1 = x;
                int y1 = level;

                int x2 = n - level - 1;
                int y2 = x;

                int num = xss.get(y2).get(x2);
                xss.get(y2).set(x2, xss.get(y1).get(x1));

                int x3 = n - x - 1;
                int y3 = n - level - 1;
                int tmp = xss.get(y3).get(x3);
                xss.get(y3).set(x3, num);
                num = tmp;

                int x4 = level;
                int y4 = n - x - 1;
                tmp = xss.get(y4).get(x4);
                xss.get(y4).set(x4, num);
                xss.get(y1).set(x1, tmp);
            }

            level++;
        }
    }

    public void additionalSpaceSolution(ArrayList<ArrayList<Integer>> xss) {
        ArrayList<ArrayList<Integer>> yss = new ArrayList<>();

        for (int i = 0; i < xss.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < xss.get(i).size(); j++) {
                row.add(xss.get(xss.size() - j - 1).get(i));
            }

            yss.add(row);
        }

        for (int i = 0; i < xss.size(); i++) {
            for (int j = 0; j < xss.size(); j++) {
                xss.get(i).set(j, yss.get(i).get(j));
            }
        }
    }

}
