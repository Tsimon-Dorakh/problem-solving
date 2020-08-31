package td.problemsolving.interviewbit.CountAndSay;

import java.util.ArrayList;
import java.util.List;

/**
 * Count And Say
 * https://www.interviewbit.com/problems/count-and-say/
 */
public class Solution {
    public String countAndSay(int x) {
        if (x <= 0) return "";

        int i = 1;
        String s = "1";

        while (i++ < x) {
            s = getNext(s);
        }

        return s;
    }

    String getNext(String s) {
        StringBuilder result = new StringBuilder();
        List<String> split = getSplit(s.toCharArray());

        for (String x : split) {
            result.append(x.length() + String.valueOf(x.toCharArray()[0]));
        }

        return result.toString();
    }

    List<String> getSplit(char[] xs) {
        List<String> result = new ArrayList<>();
        int l = 0;
        String prev = null;

        while (l < xs.length) {
            if (prev == null) prev = String.valueOf(xs[l]);
            else if (xs[l] == prev.toCharArray()[0]) prev += xs[l];
            else {
                result.add(prev);
                prev = String.valueOf(xs[l]);
            }

            l++;
        }

        if (prev != null) result.add(prev);

        return result;
    }
}
