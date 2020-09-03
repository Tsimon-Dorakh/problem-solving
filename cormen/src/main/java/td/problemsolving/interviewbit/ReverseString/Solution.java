package td.problemsolving.interviewbit.ReverseString;

import java.util.LinkedList;

/**
 * Reverse String
 * https://www.interviewbit.com/problems/reverse-string/
 */
public class Solution {
    public String reverseString(String s) {
        char[] xs = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        for (char x : xs) {
            stack.push(x);
        }

        int i = 0;
        while (!stack.isEmpty()) xs[i++] = stack.pop();

        return String.valueOf(xs);
    }
}
