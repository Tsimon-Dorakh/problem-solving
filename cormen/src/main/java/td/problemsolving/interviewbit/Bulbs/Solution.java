package td.problemsolving.interviewbit.Bulbs;

import java.util.ArrayList;

/**
 * Bulbs
 * https://www.interviewbit.com/problems/interview-questions/
 */
public class Solution {
    public int bulbs(ArrayList<Integer> xs) {
        int next = 0;
        int result = 0;

        for (int i = 0; i < xs.size(); i++) {
            if (xs.get(i) == next) {
                result++;
                next = next == 1 ? 0 : 1;
            }
        }

        return result;
    }
}
