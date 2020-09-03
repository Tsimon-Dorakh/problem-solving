package td.problemsolving.interviewbit.NearestSmallerElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Nearest Smaller Element
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 */
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> xs) {
        return OnStackSolution(xs);
    }

    ArrayList<Integer> OnStackSolution(ArrayList<Integer> xs) {
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (Integer x : xs) {
            while (!stack.isEmpty() && stack.peek() >= x) stack.pop();

            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }

            stack.push(x);
        }

        return result;
    }

    ArrayList<Integer> OnSolution(ArrayList<Integer> xs) {
        if (xs.size() == 0) return new ArrayList<>();

        ArrayList<Integer> idxs = new ArrayList<>();
        idxs.add(-1);

        for (int i = 1; i < xs.size(); i++) {
            if (xs.get(i - 1) < xs.get(i)) {
                idxs.add(i - 1);
            } else {
                int idx = idxs.get(i - 1);

                while (idx != -1 && xs.get(idx) >= xs.get(i)) idx = idxs.get(idx);
                idxs.add(idx);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer idx : idxs) {
            result.add(idx == -1 ? idx : xs.get(idx));
        }

        return result;
    }

    ArrayList<Integer> On2Solution(ArrayList<Integer> xs) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < xs.size(); i++) {
            int smallestEl = -1;

            for (int j = i - 1; j >= 0 && smallestEl == -1; j--) {
                if (xs.get(i) > xs.get(j)) {
                    smallestEl = xs.get(j);
                }
            }

            result.add(smallestEl);
        }

        return result;
    }
}
