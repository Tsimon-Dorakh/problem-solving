package td.problemsolving.interviewbit.SingleNumberII;

import java.util.List;

import static td.problemsolving.utils.Print.print;

/**
 * Single Number II
 * https://www.interviewbit.com/problems/single-number-ii/
 */
public class Solution {
    public int singleNumber(final List<Integer> xs) {
        return solution2(xs);
    }

    int solution2(final List<Integer> xs) {
        int ones = 0, twices = 0, threes = 0;

        for (Integer x : xs) {
            twices  = twices | (ones & x);
            ones    = ones ^ x;
            threes  = ones & twices;
            ones   &= ~threes;
            twices &= ~threes;
        }

        return ones;
    }

    int solution1(final List<Integer> xs) {
        int[] bits = new int[getBitCount(Integer.MAX_VALUE)];

        for (Integer x : xs) {
            for (int i = 0; i < bits.length; i++) {
                if ((x & (1 << i)) > 0) bits[i]++;
            }
        }

        int n = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] % 3 != 0) {
                n |= 1 << i;
            }
        }

        return n;
    }

    int getBitCount(int x) {
        int count = 0;

        while (x > 0) {
            count++;
            x = x & (x - 1);
        }

        return count;
    }
}
