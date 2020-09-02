package td.problemsolving.interviewbit.KthSmallestElementInTheArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kth Smallest Element in the Array
 * https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
 */
public class Solution {
    public int kthsmallest(final List<Integer> xs, int k) {
        List<Integer> ys = new ArrayList<>(xs);
        Collections.sort(ys);

        return ys.get(k - 1);
    }
}
