package td.problemsolving.interviewbit.MinimumCharactersStringPalindromic;

import static td.problemsolving.utils.Print.print;

/**
 * Minimum Characters required to make a String Palindromic
 * https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
 */
public class Solution {
    public int solve(String s) {
        return nSolution(s);
    }

    int nSolution(String s) {
        char[] ys = s.toCharArray();
        char[] xs = new char[2 * ys.length + 1];

        xs[ys.length] = '$';
        for (int i = 0; i < ys.length; i++) {
            xs[i] = ys[i];
            xs[ys.length + i + 1] = ys[ys.length - i - 1];
        }

        return ys.length - getLPS(xs)[xs.length - 1];
    }

    int[] getLPS(char[] xs) {
        int[] lps = new int[xs.length];
        int i = 1;
        int j = 0;
        lps[0] = 0;

        while (i < xs.length) {
            if (xs[i] != xs[j]) {
                while (j > 0 && xs[j] != xs[i]) j = lps[j - 1];
            }

            if (xs[i] == xs[j]) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    int n2Solution(String s) {
        char[] xs = s.toCharArray();
        int r = xs.length - 1;

        while (r > 0) {
            if (isPalindromic(xs, 0, r)) {
                return xs.length - r - 1;
            }

            r--;
        }

        return s.length() - 1;
    }

    boolean isPalindromic(char[] xs, int l, int r) {
        for (int i = 0; i <= (l + r) / 2; i++) {
            if (xs[l + i] != xs[r - i]) return false;
        }

        return true;
    }
}
