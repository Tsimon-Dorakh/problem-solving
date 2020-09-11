package td.problemsolving.hackerrank.ctcicontacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Tries: Contacts
 * https://www.hackerrank.com/challenges/ctci-contacts/problem
 */
public class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Integer count = 0;

        void add(String s) {
            add(s, 0);
        }

        void add(String s, int i) {
            if (i == s.length()) return;

            TrieNode trieNode = children.computeIfAbsent(s.charAt(i), character -> new TrieNode());
            trieNode.count++;
            trieNode.add(s, i + 1);
        }

        int findCount(String s) {
            return findCount(s, 0);
        }

        int findCount(String s, int i) {
            if (i == s.length()) return count;
            if (!children.containsKey(s.charAt(i))) return 0;
            return children.get(s.charAt(i)).findCount(s, i + 1);
        }

    }

    List<String> process(List<List<String>> input) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (List<String> c: input) {
            switch (c.get(0)) {
                case "add": root.add(c.get(1)); break;
                case "find": result.add(String.valueOf(root.findCount(c.get(1)))); break;
            }
        }

        return result;
    }
}
