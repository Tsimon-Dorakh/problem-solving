package td.problemsolving.interviewbit.DistinctNumbersInWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Distinct Numbers in Window
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> xs, int n) {
        return nSolution(xs, n);
    }

    ArrayList<Integer> nSolution(ArrayList<Integer> xs, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        while (i < n) {
            if (!map.containsKey(xs.get(i))) {
                map.put(xs.get(i), 1);
            } else {
                map.put(xs.get(i), map.get(xs.get(i)) + 1);
            }

            i++;
        }

        result.add(map.size());

        while (i < xs.size()) {
            if (map.get(xs.get(i - n)) == 1) {
                map.remove(xs.get(i - n));
            } else {
                map.put(xs.get(i - n), map.get(xs.get(i - n)) - 1);
            }

            if (!map.containsKey(xs.get(i))) {
                map.put(xs.get(i), 1);
            } else {
                map.put(xs.get(i), map.get(xs.get(i)) + 1);
            }

            result.add(map.size());

            i++;
        }

        return result;
    }

    ArrayList<Integer> nmSolution(ArrayList<Integer> xs, int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= xs.size() - n; i++) {
            result.add(new HashSet<>(xs.subList(i, i + n)).size());
        }

        return result;
    }

}
