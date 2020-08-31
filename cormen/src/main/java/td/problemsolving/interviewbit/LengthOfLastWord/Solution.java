package td.problemsolving.interviewbit.LengthOfLastWord;

/**
 * Length of Last Word
 * https://www.interviewbit.com/problems/length-of-last-word/
 */
public class Solution {
    public int lengthOfLastWord(final String s) {
        if (s.trim().length() == 0) return 0;

        char[] xs = s.trim().toCharArray();
        int i = xs.length - 2;

        while (i > 0) {
            if (xs[i] == ' ') return xs.length - (i + 1);
            i--;
        }

        return xs.length;
    }
}
