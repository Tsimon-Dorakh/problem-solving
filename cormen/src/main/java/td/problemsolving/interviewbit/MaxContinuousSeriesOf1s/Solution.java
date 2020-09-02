package td.problemsolving.interviewbit.MaxContinuousSeriesOf1s;

import java.util.ArrayList;

/**
 * Max Continuous Series of 1s
 * https://www.interviewbit.com/problems/max-continuous-series-of-1s/
 */
public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> xs, int a) {
        int l = 0;
        int r = -1;
        int max_l = 0;
        int max_r = 0;

        while (r < xs.size() - 1) {
            if (xs.get(r + 1) == 1) {
                r++;
            } else if (a > 0) {
                a--;
                r++;
            } else {
                while (a == 0) {
                    if (xs.get(l) == 0) a++;
                    l++;
                }
            }

            if (max_r - max_l < r - l) {
                max_l = l;
                max_r = r;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = max_l; i <= max_r; i++) {
            result.add(i);
        }

        return result;
    }
}
