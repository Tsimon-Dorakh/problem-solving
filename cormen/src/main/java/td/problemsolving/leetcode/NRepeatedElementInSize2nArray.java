package td.problemsolving.leetcode;

/**
 * 961. N-Repeated Element in Size 2N Array
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class NRepeatedElementInSize2nArray {
    public int repeatedNTimes(int[] xs) {
        return repeatedNTimesRandomSolution(xs);
    }

    public int repeatedNTimesSolution(int[] xs) {
        for (int i = 2; i < xs.length; i++) {
            if (xs[i] == xs[i - 1] || xs[i] == xs[i - 2]) {
                return xs[i];
            }
        }

        return xs[0];
    }

    private int repeatedNTimesRandomSolution(int[] xs) {
        int i = 0, j = 0;

        while (i == j || xs[i] != xs[j]) {
            i = random(0, xs.length);
            j = random(0, xs.length);
        }

        return xs[i];
    }

    private static int random(int a, int b) {
        return a + (int) (Math.random() * (b - a));
    }
}
