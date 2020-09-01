package td.problemsolving.interviewbit.SingleNumber;

import java.util.List;

/**
 * Single Number
 * https://www.interviewbit.com/problems/single-number/
 */
public class Solution {
    public int singleNumber(final List<Integer> xs) {
        int result = 0;

        for (Integer x : xs) {
            result ^= x;
        }

        return result;
    }
}
