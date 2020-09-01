package td.problemsolving.interviewbit.NumberOf1Bits;

/**
 * Number of 1 Bits
 * https://www.interviewbit.com/problems/number-of-1-bits/
 */
public class Solution {
    public int numSetBits(long a) {
        int count = 0;

        while (a > 0) {
            if ((a & 1) == 1) count++;
            a = a >> 1;
        }

        return count;
    }
}
