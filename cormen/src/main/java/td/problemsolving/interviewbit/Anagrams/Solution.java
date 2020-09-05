package td.problemsolving.interviewbit.Anagrams;

import java.util.*;

/**
 * Anagrams
 * https://www.interviewbit.com/problems/anagrams/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> xs) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < xs.size(); i++) {
            String s = xs.get(i);

            if (!map.containsKey(hash(s))) {
                map.put(hash(s), new ArrayList<>());
            }

            map.get(hash(s)).add(i + 1);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }

    String hash(String s) {
        char[] xs = s.toCharArray();

        Arrays.sort(xs);

        return String.valueOf(xs);
    }
}
