package td.problemsolving.interviewbit.ThreeSum;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 3 Sum
 * https://www.interviewbit.com/problems/3-sum/
 */
public class Solution {
    public int threeSumClosest(ArrayList<Integer> xs, int a) {
        Collections.sort(xs);

        Long closest = null;

        for (int i = 0; i < xs.size() - 2; i++) {
            int l = i + 1;
            int r = xs.size() - 1;

            while (l < r) {
                long sum = xs.get(i) + xs.get(l) + xs.get(r);

                if (closest == null || Math.abs(closest - a) > Math.abs(sum - a)) {
                    closest = sum;
                }

                if (sum > a) r--;
                else l++;
            }
        }

        return closest.intValue();
    }
}
