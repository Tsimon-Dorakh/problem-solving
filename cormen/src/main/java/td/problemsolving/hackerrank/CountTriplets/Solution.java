package td.problemsolving.hackerrank.CountTriplets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Count Triplets
 * https://www.hackerrank.com/challenges/count-triplets-1/problem
 */
public class Solution {
    static long countTriplets(List<Long> xs, long r) {
        long result = 0;
        Map<Long, Long> left = new HashMap<>();
        Map<Long, Long> right = new HashMap<>();

        for (Long x : xs) {
            left.put(x, 0L);
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }

        for (int i = 0; i < xs.size() - 1; i++) {
            Long b = xs.get(i);
            Long a = b / r;
            Long c = b * r;

            right.put(b, right.get(b) - 1);

            if (b % r == 0 && left.containsKey(a) && right.containsKey(c)) {
                result += left.get(a) * right.get(c);
            }

            left.put(b, left.get(b) + 1);
        }

        return result;
    }
}
