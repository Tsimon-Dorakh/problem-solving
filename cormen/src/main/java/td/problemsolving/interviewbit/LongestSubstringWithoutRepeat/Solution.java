package td.problemsolving.interviewbit.LongestSubstringWithoutRepeat;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeat
 * https://www.interviewbit.com/problems/longest-substring-without-repeat/
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int longest = 0;

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                longest = Math.max(longest, set.size());
            } else {
                while (s.charAt(l) != s.charAt(r)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
                r++;
            }
        }

        return longest;
    }
}
