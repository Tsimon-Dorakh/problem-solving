package td.problemsolving.interviewbit.LargestPermutation;

/**
 * Largest Permutation
 * https://www.interviewbit.com/problems/largest-permutation/
 */
public class Solution {
    public int[] solve(int[] xs, int b) {
        Integer[] map = new Integer[(int) 10e6];

        for (int i = 0; i < xs.length; i++) {
            map[xs[i]] = i;
        }

        int i = 0;
        while (b > 0 && i < xs.length) {
            int currentNum = xs[i];
            int targetNum = xs.length - i;

            if (currentNum != targetNum) {
                xs[i] = targetNum;
                xs[map[targetNum]] = currentNum;

                map[currentNum] = map[targetNum];

                b--;
            }

            i++;
        }

        return xs;
    }
}
