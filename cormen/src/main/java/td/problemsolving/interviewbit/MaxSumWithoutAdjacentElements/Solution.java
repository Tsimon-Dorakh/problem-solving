package td.problemsolving.interviewbit.MaxSumWithoutAdjacentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Max Sum Without Adjacent Elements
 * https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
 */
public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> xs) {
        int[] buff = new int[xs.get(0).size()];

        return adjacent(buff, xs, 0);
    }

    int adjacent(int[] buff, ArrayList<ArrayList<Integer>> xs, int i) {
        if (i >= xs.get(0).size()) return 0;

        if (buff[i] == 0) {
            int sum1 = xs.get(0).get(i) + adjacent(buff, xs, i + 2);
            int sum2 = xs.get(1).get(i) + adjacent(buff, xs, i + 2);
            int sum3 = adjacent(buff, xs, i + 1);

            buff[i] = Collections.max(Arrays.asList(sum1, sum2, sum3));
        }

        return buff[i];
    }
}
