package td.problemsolving.interviewbit.ColorfulNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Colorful Number
 * https://www.interviewbit.com/problems/colorful-number/
 */
public class Solution {
    public int colorful(int x) {
        char[] xs = String.valueOf(x).toCharArray();
        Set<Long> set = new HashSet<>();

        for (int i = 0; i < xs.length; i++) {
            long prod = 1;

            for (int j = i; j < xs.length; j++) {
                prod *= Integer.parseInt(String.valueOf(xs[j]));

                if (set.contains(prod)) return 0;

                set.add(prod);
            }
        }

        return 1;
    }
}
