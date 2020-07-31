package td.problemsolving.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        return slidingOptimized(s);
    }

    private int slidingOptimized(String s) {
        int n = s.length(), max = 0;
        int[] index = new int[128];

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            max = Math.max(max, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }

        return max;
    }

    private int sliding(String s) {
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int max = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }

    private int bruteForce(String s) {
        char[] xs = s.toCharArray();

        int max = 0;

        for (int i = 0; i < xs.length; i++) {
            Set<Character> set = new HashSet<>();

            int j = i;
            while (j < xs.length && !set.contains(xs[j])) {
                set.add(xs[j]);
                j++;
            }

            max = Math.max(max, j - i);
        }

        return max;
    }
}
