package td.problemsolving.interviewbit.GenerateAllParentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Generate all Parentheses
 * https://www.interviewbit.com/problems/generate-all-parentheses/
 */
public class Solution {
    public int isValid(String s) {
        char[] xs = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();

        for (char x : xs) {
            if (isOpen(x)) {
                stack.push(x);
            } else {
                if (stack.size() == 0) return 0;
                if (!matchParentheses(stack.pop(), x)) return 0;
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    boolean matchParentheses(char a, char b) {
        return (a == '{' && b == '}') ||
                (a == '[' && b == ']') ||
                (a == '(' && b == ')');
    }

    boolean isOpen(char x) {
        return x == '(' || x == '{' || x == '[';
    }
}
