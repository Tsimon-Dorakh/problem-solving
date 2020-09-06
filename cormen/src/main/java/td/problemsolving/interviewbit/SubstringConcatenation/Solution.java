package td.problemsolving.interviewbit.SubstringConcatenation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Substring Concatenation
 * https://www.interviewbit.com/problems/substring-concatenation/
 */
public class Solution {
    public ArrayList<Integer> findSubstring(String s, final List<String> xs) {
        return n2Solution(s, xs);
    }

    ArrayList<Integer> n2Solution(String s, final List<String> xs) {
        ArrayList<Integer> result = new ArrayList<>();

        int wordSize = xs.get(0).length();
        int subStrSize = wordSize * xs.size();
        for (int i = 0; i <= s.length() - subStrSize; i++) {
            String subStr = s.substring(i, i + subStrSize);

            List<String> xsIter = new ArrayList<>(xs);
            for (int j = 0; j <= subStr.length() - wordSize; j += wordSize) {
                xsIter.remove(subStr.substring(j, j + wordSize));
            }

            if (xsIter.size() == 0) {
                result.add(i);
            }
        }

        return result;
    }

    ArrayList<Integer> nFactorialSolution(String s, final List<String> xs) {
        ArrayList<Integer> result = new ArrayList<>();

        Set<String> concatenations = getConcatenations(xs);
        int subStrSize = xs.get(0).length() * xs.size();
        for (int i = 0; i <= s.length() - subStrSize; i++) {
            if (concatenations.contains(s.substring(i, i + subStrSize))) {
                result.add(i);
            }
        }

        return result;
    }

    Set<String> getConcatenations(List<String> xs) {
        List<List<String>> permutations = new ArrayList<>();
        permute(permutations, new ArrayList<>(xs), 0);
        Set<String> result = new HashSet<>();

        for (List<String> permutation : permutations) {
            StringBuilder s = new StringBuilder();
            for (String substr : permutation) {
                s.append(substr);
            }
            result.add(s.toString());
        }

        return result;
    }

    void permute(List<List<String>> permutations, List<String> xs, int start) {
        if (start == xs.size()) {
            permutations.add(new ArrayList<>(xs));
        } else {
            int i = start;
            while (i < xs.size()) {
                swap(xs, start, i);
                permute(permutations, xs, start + 1);
                swap(xs, start, i);
                i++;
            }
        }
    }

    void swap(List<String> xs, int i, int j) {
        String tmp = xs.get(i);
        xs.set(i, xs.get(j));
        xs.set(j, tmp);
    }
}
