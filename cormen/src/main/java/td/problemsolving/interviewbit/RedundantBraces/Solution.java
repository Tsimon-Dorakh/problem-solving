package td.problemsolving.interviewbit.RedundantBraces;

import java.util.LinkedList;

/**
 * Redundant Braces
 * https://www.interviewbit.com/problems/redundant-braces/
 */
public class Solution {
    public int braces(String s) {
        char[] xs = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        for (char x : xs) {
            if (x == '(') stack.push('(');
            else if (isOperator(x) && !stack.isEmpty() && !isOperator(stack.peek())) stack.push(x);
            else if (x == ')') {
                if (stack.peek() == '(') return 1;
                stack.pop();
                stack.pop();
            }
        }

        return 0;
    }

    boolean isOperator(char x) {
        return x == '+' || x == '-' || x =='*' || x == '/';
    }
}
