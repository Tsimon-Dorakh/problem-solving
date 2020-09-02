package td.problemsolving.interviewbit.MergeTwoSortedListsII;

import java.util.ArrayList;

/**
 * Merge Two Sorted Lists II
 * https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 */
public class Solution {
    public void merge(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        int i = 0;
        int j = 0;

        while (i < xs.size() || j < ys.size()) {
            if (i < xs.size() && j < ys.size()) {
                if (xs.get(i) < ys.get(j)) i++;
                else xs.add(i++, ys.get(j++));
            } else if (i < xs.size()) {
                i++;
            } else {
                xs.add(i++, ys.get(j++));
            }
        }
    }
}
