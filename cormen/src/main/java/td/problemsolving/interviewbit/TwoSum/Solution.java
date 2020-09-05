package td.problemsolving.interviewbit.TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2 Sum
 * https://www.interviewbit.com/problems/2-sum/
 */
public class Solution {
    public ArrayList<Integer> twoSum(final List<Integer> xs, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < xs.size(); i++) {
            if (map.containsKey(target - xs.get(i))) {
                result.add(map.get(target - xs.get(i)) + 1);
                result.add(i + 1);
                break;
            }

            if (!map.containsKey(xs.get(i))) {
                map.put(xs.get(i), i);
            }
        }

        return result;
    }
}
