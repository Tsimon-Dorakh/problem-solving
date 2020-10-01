package td.problemsolving.interviewbit.EqualAveragePartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Equal Average Partition
 * https://www.interviewbit.com/problems/equal-average-partition/
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> xs) {
        return solve(xs);
    }

    ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> xs) {
        Collections.sort(xs);

        int sum = 0;
        for (Integer x : xs) sum += x;

        for (int i = 1; i < xs.size(); i++) {
            if (Math.ceil(1. * sum * i / xs.size()) != 1. * sum * i / xs.size()) continue;
            int expectedSum = sum * i / xs.size();

            Set<Integer> left = new HashSet<>();
            if (isPossible(xs, expectedSum, i, 0, left, new HashMap<>())) {
                return toLists(xs, left);
            }
        }

        return new ArrayList<>();
    }

    boolean isPossible(ArrayList<Integer> xs, int expectedSum, int expectedSize, int from,
            Set<Integer> left, Map<Integer, Map<Integer, Map<Integer, Boolean>>> dp) {
        if (expectedSize == 0 && expectedSum == 0) return true;
        if (from >= xs.size()) return false;

        for (int i = from; i < xs.size(); i++) {
            dp.computeIfAbsent(i, a -> new HashMap<>());
            dp.get(i).computeIfAbsent(expectedSum, a -> new HashMap<>());

            if (!dp.get(i).get(expectedSum).containsKey(expectedSize)) {
                dp.get(i).get(expectedSum).put(expectedSize, true);

                left.add(i);
                if (isPossible(xs, expectedSum - xs.get(i), expectedSize - 1, i + 1, left, dp)) {
                    return true;
                }
                left.remove(i);

                if (isPossible(xs, expectedSum, expectedSize, i + 1, left, dp)) {
                    return true;
                }
            }
        }

        return false;
    }

    ArrayList<ArrayList<Integer>> toLists(ArrayList<Integer> xs, Set<Integer> left) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < xs.size(); i++) {
            if (left.contains(i)) list1.add(xs.get(i));
            else list2.add(xs.get(i));
        }

        Collections.sort(list1);
        Collections.sort(list2);

        result.add(list1);
        result.add(list2);

        return result;
    }
}
