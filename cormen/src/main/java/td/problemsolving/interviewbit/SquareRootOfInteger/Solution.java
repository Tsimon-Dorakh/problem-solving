package td.problemsolving.interviewbit.SquareRootOfInteger;

/**
 * Square Root of Integer
 * https://www.interviewbit.com/problems/square-root-of-integer/
 */
public class Solution {
    public int sqrt(int x) {
        if (x <= 1) return x;

        long l = 2;
        long r = x;

        long sqrt = (l + r) / 2;

        while (!(sqrt * sqrt <= x && (sqrt + 1) * (sqrt + 1) > x)) {
            if (sqrt * sqrt > x) {
                r = sqrt - 1;
            } else {
                l = sqrt + 1;
            }

            sqrt = (l + r) / 2;
        }

        return (int) sqrt;
    }
}
