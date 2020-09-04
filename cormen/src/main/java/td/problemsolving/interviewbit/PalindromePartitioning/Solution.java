package td.problemsolving.interviewbit.PalindromePartitioning;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Palindrome Partitioning
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 */
public class Solution {
    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> partition(String a) {
        doPartition(new ArrayList<>(), a.toCharArray(), 0);

        return result;
    }

    boolean isAllPalindromes(ArrayList<String> xs) {
        for (String x : xs) {
            if (!isPalindrome(x.toCharArray())) return false;
        }

        return true;
    }

    boolean isPalindrome(char[] xs) {
        for (int i = 0; i < (xs.length + 1) / 2; i++) {
            if (xs[i] != xs[xs.length - 1 - i]) return false;
        }

        return true;
    }

    void doPartition(ArrayList<String> state, char[] xs, int l) {
        if (state.size() == 0) {
            state.add(String.valueOf(xs[l]));

            doPartition(state, xs, l + 1);
        } else if (l >= xs.length) {
            if (isAllPalindromes(state)) result.add(state);
        } else {
            ArrayList<String> nextState = new ArrayList<>(state);
            nextState.add(String.valueOf(xs[l]));
            doPartition(nextState, xs, l + 1);

            nextState = new ArrayList<>(state);
            nextState.set(nextState.size() - 1, nextState.get(nextState.size() - 1) + xs[l]);
            doPartition(nextState, xs, l + 1);
        }
    }
}
