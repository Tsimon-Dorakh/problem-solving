package td.problemsolving.interviewbit.NextGreater;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * NEXTGREATER
 * https://www.interviewbit.com/problems/nextgreater/
 */
public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> xs) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = xs.size() - 1; i >= 0; i--) {
            int x = xs.get(i);
            while (!stack.isEmpty() && stack.peek() <= x) stack.pop();

            if (stack.isEmpty()) xs.set(i, -1);
            else xs.set(i, stack.peek());

            stack.push(x);
        }

        return xs;
    }
}
