package td.problemsolving.interviewbit.WaveArray;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Wave Array
 * https://www.interviewbit.com/problems/wave-array/
 */
public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> xs) {
        Collections.sort(xs);

        for (int i = 0; i < xs.size() - 1; i += 2) {
            Integer tmp = xs.get(i);
            xs.set(i, xs.get(i + 1));
            xs.set(i + 1, tmp);
        }

        return xs;
    }
}
