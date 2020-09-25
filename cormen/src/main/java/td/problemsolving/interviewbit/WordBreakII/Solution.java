package td.problemsolving.interviewbit.WordBreakII;

import java.util.ArrayList;

/**
 * Word Break II
 * https://www.interviewbit.com/problems/word-break-ii/
 */
public class Solution {
    public ArrayList<String> wordBreak(String s, ArrayList<String> xs) {
        ArrayList<String> result = new ArrayList<>();
        doWordBreak(result, "", s, xs, 0);

        return result;
    }

    void doWordBreak(ArrayList<String> state, String prefix, String s, ArrayList<String> dict, int l) {
        if (l >= s.length()) {
            if (prefix.length() > 0) {
                state.add(prefix.trim());
            }
        } else {
            int r = l + 1;

            while (r <= s.length()) {
                String substr = s.substring(l, r);

                if (dict.contains(substr)) {
                    doWordBreak(state, prefix + " " + substr, s, dict, r);
                }

                r++;
            }
        }
    }
}
