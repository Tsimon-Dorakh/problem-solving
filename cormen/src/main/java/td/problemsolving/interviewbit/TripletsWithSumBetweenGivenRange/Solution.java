package td.problemsolving.interviewbit.TripletsWithSumBetweenGivenRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Triplets with Sum between given range
 * https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
 */
public class Solution {
    private List<Double> as = new ArrayList<>();
    private List<Double> bs = new ArrayList<>();
    private List<Double> cs = new ArrayList<>();

    public int solve(ArrayList<String> ys) {
        for (String y : ys) {
            double x = Double.parseDouble(y);
            if (isA(x)) as.add(x);
            else if (isB(x)) bs.add(x);
            else if (isC(x)) cs.add(x);
        }

        Collections.sort(as);
        Collections.sort(bs);
        Collections.sort(cs);

        return isAAA() || isAAB() || isAAC() || isABB() || isABC()
                ? 1
                : 0;
    }

    private boolean isAAA() {
        if (as.size() < 3) return false;

        return isTupleValid(as.get(as.size() - 1), as.get(as.size() - 2), as.get(as.size() - 2));
    }

    private boolean isAAB() {
        if (as.size() < 2 || bs.size() < 1) return false;

        return isTupleValid(as.get(as.size() - 1), as.get(as.size() - 2), bs.get(bs.size() - 1));
    }

    private boolean isAAC() {
        if (as.size() < 2 || cs.size() < 1) return false;

        return isTupleValid(as.get(0), as.get(1), cs.get(0));
    }

    private boolean isABB() {
        if (as.size() < 1 || bs.size() < 2) return false;

        return isTupleValid(as.get(0), bs.get(0), bs.get(1));
    }

    private boolean isABC() {
        if (as.size() < 1 || bs.size() < 1 || cs.size() < 1) return false;

        return isTupleValid(as.get(0), bs.get(0), cs.get(0));
    }

    private boolean isTupleValid(double a, double b, double c) {
        double sum = a + b + c;

        return sum > 1 && sum < 2;
    }

    private boolean isA(double x) {
        return x < (2. / 3);
    }

    private boolean isB(double x) {
        return x >= (2. / 3) && x <= 1;
    }

    private boolean isC(double x) {
        return x > 1 && x < 2;
    }
}
