package td.problemsolving.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * ARRAY_BUG
 * https://www.interviewbit.com/problems/arraybug/
 */
public class ArrayBug {
    public ArrayList<Integer> rotateArray(List<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            ret.add(A.get((i + B) % A.size()));
        }
        return ret;
    }
}
