package td.problemsolving.interviewbit.AllFactors;


import java.util.ArrayList;

/**
 * All Factors
 * https://www.interviewbit.com/problems/all-factors/
 */
public class Solution {
    public ArrayList<Integer> allFactors(int x) {
        return fast(x);
    }

    private ArrayList<Integer> fast(int x) {
        ArrayList<Integer> xs = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                xs.add(i);
            }
        }

        for (int i = xs.size() - 1; i >= 0; i--) {
            if (x / xs.get(i) != xs.get(i)) {
                xs.add(x / xs.get(i));
            }
        }

        return xs;
    }

    private ArrayList<Integer> bruteForce(int x) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= x / 2; i++) {
            if (x % i == 0) {
                result.add(i);
            }
        }

        result.add(x);

        return result;
    }
}
