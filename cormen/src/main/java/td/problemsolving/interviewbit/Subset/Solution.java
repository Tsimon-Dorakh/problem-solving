package td.problemsolving.interviewbit.Subset;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Subset
 * https://www.interviewbit.com/problems/subset/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {
        Collections.sort(list);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.addAll(subsets(list, 0));

        return result;
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list, int l) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> xss;
        ArrayList<Integer> row;

        for (int i = l; i < list.size(); i++) {
            row = new ArrayList<>();
            row.add(list.get(i));
            result.add(row);

            if (i < list.size() - 1) {
                xss = subsets(list, i + 1);

                for (ArrayList<Integer> xs : xss) {
                    row = new ArrayList<>();
                    row.add(list.get(i));
                    row.addAll(xs);

                    result.add(row);
                }

            }
        }

        return result;
    }
}
