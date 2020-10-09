package td.problemsolving.interviewbit.GasStation;

import java.util.List;

/**
 * Gas Station
 * https://www.interviewbit.com/problems/gas-station/
 */
public class Solution {
    public int canCompleteCircuit(final List<Integer> xs, final List<Integer> ys) {
        return ONSolution(xs, ys);
    }

    int ONSolution(final List<Integer> xs, final List<Integer> ys) {
        int tank = 0;
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;

        for (int i = 0; i < xs.size(); i++) {
            sumGas += xs.get(i);
            sumCost += ys.get(i);

            tank += xs.get(i) - ys.get(i);
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        if (sumGas >= sumCost) {
            return start;
        } else {
            return -1;
        }
    }

    int ONSquareSolution(final List<Integer> xs, final List<Integer> ys) {
        for (int i = 0; i < xs.size(); i++) {
            if (check(xs, ys, i)) return i;
        }

        return -1;
    }

    boolean check(final List<Integer> xs, final List<Integer> ys, int from) {
        int pos = from;
        boolean started = false;
        int gas = xs.get(from);

        while (pos != from || !started) {
            started = true;

            gas -= ys.get(pos);
            if (gas < 0) return false;

            pos = (pos + 1) % xs.size();
            gas += xs.get(pos);
        }

        return gas >= 0;
    }
}
