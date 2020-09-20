package td.problemsolving.interviewbit.Inversions;

import java.util.ArrayList;
import java.util.Collections;

/**
 * INVERSIONS
 * https://www.interviewbit.com/problems/inversions/
 */
public class Solution {
    int count = 0;

    public int countInversions(ArrayList<Integer> xs) {
        return NLogNSolution(xs);
    }

    int NLogNSolution(ArrayList<Integer> xs) {
        mergeSort(xs, 0, xs.size() - 1);

        return count;
    }

    void mergeSort(ArrayList<Integer> xs, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;

        mergeSort(xs, l, m);
        mergeSort(xs, m + 1, r);
        merge(xs, l, m + 1, r);
    }

    void merge(ArrayList<Integer> xs, int l0, int m0, int r) {
        ArrayList<Integer> buff = new ArrayList<>();

        for (int i = l0; i <= r; i++) {
            buff.add(xs.get(i));
        }

        int l = l0;
        int m = m0;
        int i = l0;

        while (l < m0 && m <= r) {
            if (buff.get(l - l0) <= buff.get(m - l0)) {
                xs.set(i++, buff.get(l++ - l0));
            } else {
                xs.set(i++, buff.get(m++ - l0));

                count += m0 - l;
            }
        }

        while (l < m0) xs.set(i++, buff.get(l++ - l0));
        while (m <= r) xs.set(i++, buff.get(m++ - l0));
    }

    int N2Solution(ArrayList<Integer> xs) {
        int count = 0;

        for (int i = 0; i < xs.size() - 1; i++) {
            for (int j = i + 1; j < xs.size(); j++) {
                if (xs.get(i) > xs.get(j)) count++;
            }
        }

        return count;
    }
}
