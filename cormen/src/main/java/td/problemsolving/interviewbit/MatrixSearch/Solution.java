package td.problemsolving.interviewbit.MatrixSearch;

import java.util.ArrayList;

/**
 * Matrix Search
 * https://www.interviewbit.com/problems/matrix-search/
 */
public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> xss, int x) {
        int N = xss.size();
        int M = xss.get(0).size();
        int l = 0;
        int r = N - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (xss.get(m).get(0) > x) r = m - 1;
            else if (xss.get(m).get(M - 1) < x) l = m + 1;
            else l = r = m;
        }

        int row = l;
        l = 0;
        r = M - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (xss.get(row).get(m) > x) r = m - 1;
            else if (xss.get(row).get(m) < x) l = m + 1;
            else return 1;
        }

        return 0;
    }
}
