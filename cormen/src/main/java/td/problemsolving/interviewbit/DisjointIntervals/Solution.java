package td.problemsolving.interviewbit.DisjointIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Disjoint Intervals
 * https://www.interviewbit.com/problems/disjoint-intervals/
 */
public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> xss) {
        if (xss.size() == 0) return 0;

        xss.sort(Comparator.comparingInt(a -> a.get(1)));

        ArrayList<Integer> last = xss.get(0);
        int count = 1;

        for (int i = 1; i < xss.size(); i++) {
            if (!isOverlap(last, xss.get(i))) {
                count++;
                last = xss.get(i);
            }
        }

        return count;
    }

    boolean isOverlap(ArrayList<Integer> x, ArrayList<Integer> y) {
        return Math.max(x.get(0), y.get(0)) <= Math.min(x.get(1), y.get(1));
    }
}
