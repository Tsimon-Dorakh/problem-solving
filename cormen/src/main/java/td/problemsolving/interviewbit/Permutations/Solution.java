package td.problemsolving.interviewbit.Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Permutations
 * https://www.interviewbit.com/problems/permutations/
 */
public class Solution {
    ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> xs) {
        doPermute(xs, 0, xs.size());

        permutations.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i).compareTo(o2.get(i)) != 0)
                    return o1.get(i).compareTo(o2.get(i));
            }

            return 0;
        });

        return permutations;
    }

    void doPermute(ArrayList<Integer> xs, int l, int r) {
        if (l == r) {
            permutations.add(new ArrayList<>(xs));
        } else {
            for (int i = l; i < r; i++) {
                swap(xs, l, i);
                doPermute(xs, l + 1, r);
                swap(xs, l, i);
            }
        }

    }

    void doPermute(ArrayList<ArrayList<Integer>> permutations, ArrayList<Integer> prev, ArrayList<Integer> xs) {
        for (int i = 0; i < xs.size(); i++) {
            prev.add(xs.get(i));

            ArrayList<Integer> nextSet = new ArrayList<>(xs);
            nextSet.remove(i);

            if (nextSet.size() > 0) {
                doPermute(permutations, prev, nextSet);
            } else {
                permutations.add(new ArrayList<>(prev));
            }

            prev.remove(prev.size() - 1);
        }
    }

    void swap(ArrayList<Integer> xs, int l, int r){
        int temp = xs.get(l);
        xs.set(l,xs.get(r));
        xs.set(r,temp);
    }
}
