package td.problemsolving.interviewbit.AssignMiceToHoles;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Assign Mice to Holes
 * https://www.interviewbit.com/problems/assign-mice-to-holes/
 */
public class Solution {
    public int mice(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        Collections.sort(xs);
        Collections.sort(ys);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < xs.size(); i++) {
            max = Math.max(max, Math.abs(xs.get(i) - ys.get(i)));
        }

        return max;
    }
}
