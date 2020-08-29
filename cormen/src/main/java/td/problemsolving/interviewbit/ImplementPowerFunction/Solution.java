package td.problemsolving.interviewbit.ImplementPowerFunction;

/**
 * Implement Power Function
 * https://www.interviewbit.com/problems/implement-power-function/
 */
public class Solution {
    public int pow(int x, int n, int d) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (x < 0) return pow(d + x, n, d);

        long a;

        long b = pow(x, n / 2, d);
        if (n % 2 == 0) {
            a = (b * b) % d;
        } else {
            a = (((x * b) % d) * b) % d;
        }

        return (int) (a % d);
    }
}
