package td.problemsolving.interviewbit.AmazingSubarrays;

/**
 * Amazing Subarrays
 * https://www.interviewbit.com/problems/amazing-subarrays/
 */
public class Solution {
    public int solve(String s) {
        char[] xs = s.toLowerCase().toCharArray();

        int result = 0;
        for (int i = 0; i < xs.length; i++) {
            if (isAmazing(xs[i])) {
                result += xs.length - i;
                result %= 10003;
            }
        }

        return result;
    }

    boolean isAmazing(char c) {
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u';
    }
}
