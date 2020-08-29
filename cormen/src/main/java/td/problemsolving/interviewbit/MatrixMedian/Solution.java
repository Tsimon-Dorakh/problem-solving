package td.problemsolving.interviewbit.MatrixMedian;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Matrix Median
 * https://www.interviewbit.com/problems/matrix-median/
 */
public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> xss) {
        int min = findMin(xss);
        int max = findMax(xss);

        int desired = (xss.size() * xss.get(0).size() + 1) / 2;

        while (min < max) {
            int m = (min + max) / 2;
            int nums = 0;

            for (ArrayList<Integer> xs : xss) {
                int i = Collections.binarySearch(xs, m);

                if (i < 0) {
                    i = -i - 1;
                } else {
                    while (i < xs.size() && xs.get(i) == m) i++;
                }

                nums += i;
            }

            if (nums < desired) {
                min = m + 1;
            } else {
                max = m;
            }
        }

        return min;
    }

    private int findMin(ArrayList<ArrayList<Integer>> xss) {
        int min = xss.get(0).get(0);

        for (ArrayList<Integer> xs : xss) {
            min = Math.min(xs.get(0), min);
        }

        return min;
    }

    private int findMax(ArrayList<ArrayList<Integer>> xss) {
        int max = xss.get(0).get(xss.get(0).size() - 1);

        for (ArrayList<Integer> xs : xss) {
            max = Math.max(xs.get(xs.size() - 1), max);
        }

        return max;
    }
}
