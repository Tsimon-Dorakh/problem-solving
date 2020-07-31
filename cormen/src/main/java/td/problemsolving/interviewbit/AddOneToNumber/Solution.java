package td.problemsolving.interviewbit.AddOneToNumber;

import java.util.ArrayList;

/**
 * Add One To Number
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class Solution {
    private ArrayList<Integer> normalize(ArrayList<Integer> xs) {
        ArrayList<Integer> ys = new ArrayList<>();
        ys.add(0);

        boolean zero = true;

        for (Integer x : xs) {
            if (!zero || x != 0) {
                zero = false;
                ys.add(x);
            }
        }

        return ys;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> xs) {
        xs = normalize(xs);

        int carry = 1;

        for (int i = xs.size() - 1; i >= 0; i--) {
            int x = xs.get(i) + carry;
            carry = x / 10;

            xs.set(i, x % 10);
        }

        return xs.get(0) == 0 ? new ArrayList<>(xs.subList(1, xs.size())) : xs;
    }
}
