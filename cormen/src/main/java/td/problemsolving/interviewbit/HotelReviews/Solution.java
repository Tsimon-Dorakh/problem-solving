package td.problemsolving.interviewbit.HotelReviews;

import java.util.*;

/**
 * Hotel Reviews
 * https://www.interviewbit.com/problems/hotel-reviews/
 */
public class Solution {
    public ArrayList<Integer> solve(String s, ArrayList<String> xs) {
        return nSolution(s, xs);
    }

    ArrayList<Integer> nSolution(String s, ArrayList<String> xs) {
        TrieNode dictionary = new TrieNode();
        for (String word : splitWords(s)) {
            dictionary.add(word);
        }

        List<ResultItem> resultItems = new ArrayList<>();
        for (int i = 0; i < xs.size(); i++) {
            int goodnessValue = 0;
            for (String word : splitWords(xs.get(i))) {
                if (dictionary.contains(word)) goodnessValue++;
            }

            resultItems.add(new ResultItem(i, goodnessValue));
        }

        resultItems.sort(Collections.reverseOrder(Comparator.comparing(o -> o.goodnessValue)));

        ArrayList<Integer> result = new ArrayList<>();
        for (ResultItem item : resultItems) {
            result.add(item.position);
        }

        return result;
    }

    ArrayList<Integer> n2Solution(String s, ArrayList<String> xs) {
        Set<String> dictionary = new HashSet<>(splitWords(s));
        List<ResultItem> resultItems = new ArrayList<>();
        for (int i = 0; i < xs.size(); i++) {
            resultItems.add(new ResultItem(i, getGoodnessValue(dictionary, xs.get(i))));
        }

        resultItems.sort(Collections.reverseOrder(Comparator.comparing(o -> o.goodnessValue)));

        ArrayList<Integer> result = new ArrayList<>();
        for (ResultItem item : resultItems) {
            result.add(item.position);
        }

        return result;
    }

    Integer getGoodnessValue(Set<String> dictionary, String s) {
        int result = 0;

        for (String word : splitWords(s)) {
            if (dictionary.contains(word)) {
                result++;
            }
        }

        return result;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end = false;

        void add(String s) {
            add(s, 0);
        }

        void add(String s, int i) {
            if (s.length() == i) {
                end = true;
                return;
            }

            TrieNode trieNode = children.computeIfAbsent(s.charAt(i), o -> new TrieNode());
            trieNode.add(s, i + 1);
        }

        boolean contains(String s) {
            return contains(s, 0);
        }

        boolean contains(String s, int i) {
            if (s.length() == i) return end;

            return children.containsKey(s.charAt(i)) && children.get(s.charAt(i)).contains(s, i + 1);
        }
    }

    class ResultItem {
        Integer position;
        Integer goodnessValue;

        public ResultItem(Integer position, Integer goodnessValue) {
            this.position = position;
            this.goodnessValue = goodnessValue;
        }
    }

    List<String> splitWords(String s) {
        return Arrays.asList(s.split("_"));
    }
}
