package td.problemsolving.interviewbit.FirstNonRepeatingCharacterInAStreamOfCharacters;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * First non-repeating character in a stream of characters
 * https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
 */
public class Solution {
    public String solve(String s) {
        char[] xs = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        Set<Character> repeated = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char x : xs) {
            if (!repeated.contains(x)) {
                if (!queue.contains(x)) {
                    queue.addLast(x);
                } else {
                    queue.remove((Character) x);
                    repeated.add(x);
                }
            }

            if (queue.size() > 0) result.append(queue.getFirst());
            else result.append('#');
        }

        return result.toString();

    }
}
