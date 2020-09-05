package td.problemsolving.interviewbit.PairsWithGivenXor;

import java.util.*;

/**
 * Pairs With Given Xor
 * https://www.interviewbit.com/problems/pairs-with-given-xor/
 */
public class Solution {
    public int solve(ArrayList<Integer> xs, int b) {
        return OnSolution(xs, b);
    }

    int OnSolution(ArrayList<Integer> xs, int b) {
        Set<Integer> set = new HashSet<>();
        int total = 0;

        for (Integer x : xs) {
            if (set.contains(x)) {
                total++;
            }

            set.add(x ^ b);
        }

        return total;
    }

    int bruteForce(ArrayList<Integer> xs, int b) {
        int total = 0;

        for (int i = 0; i < xs.size() - 1; i++) {
            for (int j = i + 1; j < xs.size(); j++) {
                if ((xs.get(i) ^ xs.get(j)) == b) {
                    System.out.printf("%d %d\n", xs.get(i), xs.get(j));
                    total++;
                }
            }
        }

        return total;
    }

}
