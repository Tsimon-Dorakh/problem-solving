package td.problemsolving.interviewbit.ModularExpression;

/**
 * Modular Expression
 * https://www.interviewbit.com/problems/modular-expression/
 */
public class Solution {
    public int Mod(int a, int b, int c) {
        return (int) ((calc(a, b, c) + c) % c);
    }

    long calc(long a, long b, long c) {
        if (b == 0) return a > 0 ? 1 : 0;
        if (b == 1) return a;

        if (b % 2 == 1) {
            long x = calc(a, b - 1, c) % c;
            return (a * x) % c;
        } else {
            long x = calc(a, b / 2, c) % c;
            return (x * x) % c;
        }
    }
}
