package td.problemsolving.interviewbit.HighestProduct;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Highest Product
 * https://www.interviewbit.com/problems/highest-product/
 */
public class Solution {
    public int maxp3(ArrayList<Integer> xs) {
        if (xs.size() < 3) return 0;

        xs.sort(Collections.reverseOrder());

        return Math.max(
                xs.get(0) * xs.get(1) * xs.get(2),
                xs.get(0) * xs.get(xs.size() - 1) * xs.get(xs.size() - 2)
        );
    }
}
