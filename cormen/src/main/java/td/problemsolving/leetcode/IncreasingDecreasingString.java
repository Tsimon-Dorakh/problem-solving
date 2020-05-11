package td.problemsolving.leetcode;

/**
 * 1370. Increasing Decreasing String
 * https://leetcode.com/problems/increasing-decreasing-string/
 */
public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] cs = new int[26];

        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }

        int n = s.length();
        StringBuilder result = new StringBuilder();
        int i = 0;
        int dir = 1;
        while (n > 0) {
            if (i < 0) {
                dir = 1;
            } else if (i == cs.length) {
                dir = -1;
            } else if (cs[i] > 0) {
                cs[i]--;
                n--;

                result.append((char)('a' + i));
            }

            i += dir;
        }

        return result.toString();
    }
}
