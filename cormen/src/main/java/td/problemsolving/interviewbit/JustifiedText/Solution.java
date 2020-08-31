package td.problemsolving.interviewbit.JustifiedText;

import java.util.ArrayList;

/**
 * Justified Text
 * https://www.interviewbit.com/problems/justified-text/
 */
public class Solution {
    public ArrayList<String> fullJustify(ArrayList<String> xs, int l) {
        ArrayList<String> result = new ArrayList<>();

        while (xs.size() > 0) {
            ArrayList<String> row = nextRow(xs, l);
            result.add(xs.size() > 0 ? join(true, row, l - getRowSize(row)) : joinLast(row, l));
        }

        return result;
    }

    String joinLast(ArrayList<String> xs, int l) {
        String s = String.join(" ", xs);

        s += getSpaces(l - s.length());

        return s;
    }

    String join(boolean isFirst, ArrayList<String> words, int spaces) {
        if (words.size() == 0) return getSpaces(spaces);
        if (isFirst) return words.get(0) + join(false, new ArrayList<>(words.subList(1, words.size())), spaces);

        int cur_spaces = (int) Math.ceil(1. * spaces / (words.size()));
        return getSpaces(cur_spaces) + words.get(0) + join(false, new ArrayList<>(words.subList(1, words.size())), spaces - cur_spaces);

    }

    String getSpaces(int size) {
        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < size; i++) spaces.append(" ");

        return spaces.toString();
    }

    int getRowSize(ArrayList<String> xs) {
        int size = 0;

        for (String x : xs) {
            size += x.length();
        }

        return size;
    }

    ArrayList<String> nextRow(ArrayList<String> xs, int l) {
        ArrayList<String> row = new ArrayList<>();

        while (xs.size() > 0 && l >= xs.get(0).length()) {
            row.add(xs.get(0));
            l -= xs.get(0).length() + (row.size() > 0 ? 1 : 0);
            xs.remove(0);
        }

        return row;
    }

}
