package td.problemsolving.interviewbit.MergeIntervals;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Merge Intervals
 * https://www.interviewbit.com/problems/merge-intervals/
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        return hasIntersection(intervals, newInterval) ?
                solveWithIntersection(intervals, newInterval) :
                solveNoIntersection(intervals, newInterval);
    }

    private ArrayList<Interval> solveNoIntersection(ArrayList<Interval> xs, Interval y) {
        ArrayList<Interval> result = new ArrayList<>();

        xs.add(0, new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE));
        xs.add(xs.size(), new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));

        for (int i = 1; i < xs.size(); i++) {
            if (less(xs.get(i - 1), y) && less(y, xs.get(i))) {
                result.add(y);
            }

            if (i != xs.size() - 1) result.add(xs.get(i));
        }

        return result;
    }

    private ArrayList<Interval> solveWithIntersection(ArrayList<Interval> xs, Interval y) {
        ArrayList<Interval> result = new ArrayList<>();

        boolean findIntersectInterval = false;

        for (Interval x : xs) {
            if (intersect(x, y)) {
                findIntersectInterval = true;

                y = new Interval(Math.min(x.start, y.start), Math.max(x.end, y.end));
            } else if (findIntersectInterval && y != null) {
                result.add(y);
                result.add(x);
                y = null;
            } else {
                result.add(x);
            }
        }

        if (y != null) {
            result.add(y);
        }

        return result;
    }

    private boolean less(Interval x, Interval y) {
        return x.end < y.start;
    }

    private boolean hasIntersection(ArrayList<Interval> xs, Interval y) {
        for (Interval x : xs) {
            if (intersect(x, y)) return true;
        }

        return false;
    }

    private boolean intersect(Interval x, Interval y) {
        if (x == null || y == null) return false;

        return Math.max(x.start, y.start) <= Math.min(x.end, y.end);
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start &&
                    end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
