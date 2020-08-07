package td.problemsolving.interviewbit.FindDuplicateInArray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find Duplicate in Array
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 */
public class Solution {
    public int repeatedNumber(final List<Integer> xs) {
        return NSpaceSolution(xs);
    }

    private int NSpaceSolution(final List<Integer> xs) {
        Set<Integer> set = new HashSet<>();

        for (Integer x : xs) {
            if (set.contains(x)) return x;
            set.add(x);
        }

        return -1;
    }

}
