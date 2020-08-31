package td.problemsolving.interviewbit.CompareVersionNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Compare Version Numbers
 * https://www.interviewbit.com/problems/compare-version-numbers/
 */
public class Solution {
    public int compareVersion(String a, String b) {
        List<String> as = new ArrayList<>(Arrays.asList(a.split("\\.")));
        List<String> bs = new ArrayList<>(Arrays.asList(b.split("\\.")));

        if (as.size() < bs.size()) {
            for (int i = 1; i <= bs.size() - as.size(); i++) as.add("");
        } else if (as.size() > bs.size()) {
            for (int i = 1; i <= as.size() - bs.size(); i++) bs.add("");
        }

        for (int i = 0; i < as.size(); i++) {
            if (compareSingleVersion(as.get(i), bs.get(i)) != 0) {
                return compareSingleVersion(as.get(i), bs.get(i));
            }
        }

        return 0;
    }

    private int compareSingleVersion(String a, String b) {
        a = removeZeros(a);
        b = removeZeros(b);

        if (a.length() > b.length()) return 1;
        if (a.length() < b.length()) return -1;

        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();

        for (int i = 0; i < as.length; i++) {
            if (as[i] < bs[i]) return -1;
            if (as[i] > bs[i]) return 1;
        }

        return 0;
    }

    private String removeZeros(String s) {
        return s.replaceFirst("^0+", "");
    }
}
