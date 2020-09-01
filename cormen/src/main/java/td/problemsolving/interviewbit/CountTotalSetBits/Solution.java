package td.problemsolving.interviewbit.CountTotalSetBits;

/**
 * Count Total Set Bits
 * https://www.interviewbit.com/problems/count-total-set-bits/
 */
public class Solution {
    public int solve(int x) {
        return betterSolution(x);
    }

    int betterSolution(int x) {
        int i = 1;
        int count = 0;
        int modulo = (int) (1e9 + 7);

        while (x >= pow(2, i - 1)) {
            count += ((x + 1) / pow(2, i)) * pow(2, i - 1);
            count += Math.max(0, (x + 1) % pow(2, i) - pow(2, i - 1));
            count = count % modulo;

            i++;
        }

        return count;
    }

    int pow(int x, int pow) {
        return (int) Math.pow(x, pow);
    }

    int ONSolution(int x) {
        int modulo = (int) (Math.pow(10, 9) + 7);
        int count = 0;

        for (int i = 1; i <= x; i++) {
            count += getBitCount(i);
            count = count % modulo;
        }

        return count;
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
