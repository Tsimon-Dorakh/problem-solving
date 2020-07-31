package td.problemsolving.interviewbit.PrimeNumbers;

import java.util.ArrayList;

/**
 * Prime Numbers
 * https://www.interviewbit.com/problems/prime-numbers/
 */
public class Solution {
    public ArrayList<Integer> sieve(int x) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i <= x; i++) {
            if (isPrime(i) == 1) {
                result.add(i);
            }
        }

        return result;
    }

    private int isPrime(int x) {
        if (x == 1) return 0;
        if (x <= 3) return 1;

        for (int i = 2; i <= (int)Math.sqrt(x); i++) {
            if (x % i == 0) return 0;
        }

        return 1;
    }
}
