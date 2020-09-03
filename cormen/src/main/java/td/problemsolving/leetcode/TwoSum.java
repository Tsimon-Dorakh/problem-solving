package td.problemsolving.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] xs, int target) {
        return OnSolution(xs, target);
    }

    int[] OnSolution(int[] xs, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < xs.length; i++) {
            if (map.containsKey(target - xs[i])) {
                return new int[]{map.get(target - xs[i]), i};
            }

            map.put(xs[i], i);
        }

        throw new RuntimeException("Unsupported case");
    }

    int[] On2Solution(int[] xs, int target) {
        for (int i = 0; i < xs.length - 1; i++) {
            for (int j = i + 1; j < xs.length; j++) {
                if (xs[i] +  xs[j] == target) return new int[]{i, j};
            }
        }

        throw new RuntimeException("Unsupported case");
    }
}
