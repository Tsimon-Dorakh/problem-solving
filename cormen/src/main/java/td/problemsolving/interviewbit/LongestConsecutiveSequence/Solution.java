package td.problemsolving.interviewbit.LongestConsecutiveSequence;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * https://www.interviewbit.com/problems/longest-consecutive-sequence/
 */
public class Solution {
    public int longestConsecutive(final List<Integer> xs) {
        if (xs.size() == 0) return 0;

        return nSolution(xs);
    }

    int nSolution(List<Integer> xs) {
        int longest = 0;

        Set<Integer> set = new HashSet<>(xs);
        while (!set.isEmpty()) {
            Integer x = set.iterator().next();
            int current = 1;
            set.remove(x);

            int y = x - 1;
            while (set.contains(y)) {
                current++;
                set.remove(y);
                y--;
            }

            y = x + 1;
            while (set.contains(y)) {
                current++;
                set.remove(y);
                y++;
            }

            longest = Math.max(longest, current);
        }

        return longest;
    }

    int nLognSolution(List<Integer> xs) {
        Collections.sort(xs);

        int longest = 1;
        int current = 1;
        for (int i = 1; i < xs.size(); i++) {
            if (xs.get(i).equals(xs.get(i - 1))) {
                continue;
            } else if (xs.get(i) - 1 == xs.get(i - 1)) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
        }

        return longest;
    }


}
