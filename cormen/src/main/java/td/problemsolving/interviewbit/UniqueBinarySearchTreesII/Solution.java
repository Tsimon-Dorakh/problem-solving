package td.problemsolving.interviewbit.UniqueBinarySearchTreesII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Unique Binary Search Trees II
 * https://www.interviewbit.com/problems/unique-binary-search-trees-ii/
 */
public class Solution {
    public int numTrees(int x) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= x; i++) {
            set.add(i);
        }

        return calculate(new HashMap<>(), set);
    }

    int calculate(Map<Set<Integer>, Integer> dp, Set<Integer> set) {
        int count = 0;

        if (set.isEmpty()) return 0;
        if (set.size() == 1) return 1;

        if (!dp.containsKey(set)) {
            for (Integer x : set) {
                int a = Math.max(1, calculate(dp, getLessThan(x, set)));
                int b = Math.max(1, calculate(dp, getMoreThan(x, set)));

                count += a * b;
            }

            dp.put(set, count);
        }

        return dp.get(set);
    }

    Set<Integer> getLessThan(int x, Set<Integer> set) {
        Set<Integer> result = new HashSet<>();

        for (Integer a : set) {
            if (a < x) result.add(a);
        }


        return result;
    }

    Set<Integer> getMoreThan(int x, Set<Integer> set) {
        Set<Integer> result = new HashSet<>();

        for (Integer a : set) {
            if (a > x) result.add(a);
        }

        return result;
    }
}
