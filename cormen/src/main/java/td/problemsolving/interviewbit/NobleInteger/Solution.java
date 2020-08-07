package td.problemsolving.interviewbit.NobleInteger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Noble Integer
 * https://www.interviewbit.com/problems/noble-integer/
 */
public class Solution {
    public int solve(ArrayList<Integer> xs) {
        Collections.sort(xs);

        for (int i = 0; i < xs.size(); i++) {
            if (xs.size() - i - 1 == xs.get(i)) {
                if (xs.get(i) == 0 || (i < xs.size() - 1 && xs.get(i + 1) > xs.get(i))) {
                    return 1;
                }
            }
        }

        return -1;
    }
}
