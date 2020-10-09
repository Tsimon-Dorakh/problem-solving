package td.problemsolving.interviewbit.MajorityElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Majority Element
 * https://www.interviewbit.com/problems/majority-element/
 */
public class Solution {
    public int majorityElement(final List<Integer> xs) {
        int count = 1;
        int idx = 0;

        for (int i = 1; i < xs.size(); i++) {
            if (!xs.get(idx).equals(xs.get(i))) count--;
            else count++;

            if (count == 0) {
                idx = i;
                count = 1;
            }
        }

        return xs.get(idx);
    }

    int additionalSpaceSolution(final List<Integer> xs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer x : xs) {
            map.putIfAbsent(x, 0);

            map.put(x, map.get(x) + 1);
        }

        int max = xs.get(0);

        for (Integer key : map.keySet()) {
            if (map.get(key) > map.get(max)) {
                max = key;
            }
        }

        return max;
    }
}
