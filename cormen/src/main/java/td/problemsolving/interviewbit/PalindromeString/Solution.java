package td.problemsolving.interviewbit.PalindromeString;

/**
 * Palindrome String
 * https://www.interviewbit.com/problems/palindrome-string/
 */
public class Solution {
    public int isPalindrome(String s) {
        int[] xs = s.toLowerCase()
                .chars()
                .filter(x -> (x >= 'a' && x <= 'z') || (x >= '0' && x <= '9'))
                .toArray();

        for (int i = 0; i < xs.length / 2; i++) {
            if (xs[i] != xs[xs.length - i - 1]) {
                return 0;
            }
        }

        return 1;
    }
}
