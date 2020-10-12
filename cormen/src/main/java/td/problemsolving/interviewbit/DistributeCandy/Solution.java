package td.problemsolving.interviewbit.DistributeCandy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Distribute Candy
 * https://www.interviewbit.com/problems/distribute-candy/
 */
public class Solution {
    public int candy(ArrayList<Integer> xs) {
        return nSolution(xs);
    }

    int nSolution(ArrayList<Integer> xs) {
        int[] candies = new int[xs.size()];
        Arrays.fill(candies, 1);

        for (int i = 1; i < xs.size(); i++) {
            if (xs.get(i) > xs.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = xs.size() - 2; i >= 0; i--) {
            if (xs.get(i) > xs.get(i + 1)) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int i = 0; i < xs.size(); i++) sum += candies[i];

        return sum;
    }
}
