package td.problemsolving.hackerrank.FindTheRunningMedian;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the Running Median
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 */
public class Solution {
    static double[] runningMedian(int[] xs) {
        return NLogNSolution(xs);
    }

    static double[] NLogNSolution(int[] xs) {
        double[] result = new double[xs.length];
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < xs.length; i++) {
            if (lowers.isEmpty() || xs[i] <= lowers.peek()) {
                lowers.add(xs[i]);
            } else {
                highers.add(xs[i]);
            }

            PriorityQueue<Integer> smaller = highers.size() > lowers.size() ? lowers : highers;
            PriorityQueue<Integer> bigger = highers.size() > lowers.size() ? highers : lowers;

            if (Math.abs(highers.size() - lowers.size()) >= 2) {
                smaller.add(bigger.poll());
            }

            if ((smaller.size() + bigger.size()) % 2 == 1) {
                result[i] = bigger.peek();
            } else {
                result[i] = (bigger.peek() + smaller.peek()) / 2.;
            }

        }

        return result;
    }

    static double[] N2Solution(int[] xs) {
        double[] result = new double[xs.length];

        for (int i = 0; i < xs.length; i++) {
            System.out.println(i);

            result[i] = sortAndGetMedian(Arrays.copyOfRange(xs, 0, i + 1));
        }

        return result;
    }

    static double sortAndGetMedian(int[] xs) {
        int from = 0;
        int to = xs.length - 1;

        Arrays.sort(xs);

        if ((to - from) % 2 == 0) {
            return xs[(from + to) / 2];
        } else {
            return (1. * xs[(from + to) / 2] + xs[(from + to + 1) / 2]) / 2;
        }
    }
}
