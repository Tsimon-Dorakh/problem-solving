package td.problemsolving.interviewbit.PrimeSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Prime Sum
 * https://www.interviewbit.com/problems/prime-sum/
 */
public class Solution {
    public ArrayList<Integer> primesum(int x) {
        for (int i = 2; i <= x / 2; i++) {
            if (isPrime(i) && isPrime(x - i)) {
                return new ArrayList<>(Arrays.asList(i, x - i));
            }
        }


        return null;
    }

    boolean isPrime(int x) {
        if (x == 1) return false;
        if (x <= 3) return true;

        for (int i = 2; i <= (int)Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}
