package td.problemsolving.interviewbit.RemoveDuplicatesFromSortedArray;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Remove Duplicates from Sorted Array
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public int removeDuplicates(ArrayList<Integer> xs) {
        Set<Integer> set = new TreeSet<>(xs);
        xs.clear();
        xs.addAll(set);

        return xs.size();
    }
}
