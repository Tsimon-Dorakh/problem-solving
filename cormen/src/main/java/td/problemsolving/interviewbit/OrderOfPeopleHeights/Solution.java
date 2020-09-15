package td.problemsolving.interviewbit.OrderOfPeopleHeights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Order of People Heights
 * https://www.interviewbit.com/problems/order-of-people-heights/
 */
public class Solution {
    public ArrayList<Integer> order(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        return ON2Solution(xs, ys);
    }

    ArrayList<Integer> ON2Solution(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        List<Height> heights = new ArrayList<>();
        Integer[] order = new Integer[xs.size()];

        for (int i = 0; i < xs.size(); i++) {
            heights.add(new Height(xs.get(i), ys.get(i)));
        }

        heights.sort((a, b) -> Integer.compare(a.height, b.height));

        for (Height height : heights) {
            int taller = height.inFront;
            int pos = 0;

            while (taller > 0 || order[pos] != null) {
                if (order[pos] == null || order[pos] > height.height) {
                    taller--;
                }

                pos++;
            }

            order[pos] = height.height;
        }

        return new ArrayList<>(Arrays.asList(order));
    }

    class Height {
        int height;
        int inFront;

        public Height(int height, int inFront) {
            this.height = height;
            this.inFront = inFront;
        }

        @Override
        public String toString() {
            return "Height{" + "height=" + height + ", inFront=" + inFront + '}';
        }
    }

    ArrayList<Integer> OFactSolution(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        Map<Integer, Integer> heights = new HashMap<>();
        for (int i = 0; i < xs.size(); i++) {
            heights.put(xs.get(i), ys.get(i));
        }

        ArrayList<ArrayList<Integer>> options = getPermutations(xs);

        for (ArrayList<Integer> option : options) {
            if (isValid(heights, option)) {
                return option;
            }
        }

        throw new RuntimeException("Unsupported case");
    }

    boolean isValid(Map<Integer, Integer> heights, ArrayList<Integer> xs) {
        boolean isValid = true;

        for (int i = 0; i < xs.size(); i++) {
            int countMoreThan = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (xs.get(j) > xs.get(i)) countMoreThan++;
            }

            if (countMoreThan != heights.get(xs.get(i))) isValid = false;
        }

        return isValid;
    }

    ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> xs) {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

        getPermutations(permutations, xs, 0);

        return permutations;
    }

    void getPermutations(ArrayList<ArrayList<Integer>> permutations, ArrayList<Integer> xs, int l) {
        if (l == xs.size()) {
            permutations.add(new ArrayList<>(xs));
        } else {
            for (int r = l; r < xs.size(); r++) {
                swap(xs, l, r);
                getPermutations(permutations, xs, l + 1);
                swap(xs, l, r);
            }
        }
    }

    void swap(ArrayList<Integer> xs, int i, int j) {
        Integer tmp = xs.get(i);
        xs.set(i, xs.get(j));
        xs.set(j, tmp);
    }
}
