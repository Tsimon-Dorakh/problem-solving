package td.problemsolving.interviewbit.MergeOverlappingIntervals;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Merge Overlapping Intervals
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> xs) {
        if (xs.size() <= 1) return xs;

        ArrayList<Interval> result = new ArrayList<>();

        xs.sort((a, b) -> {
            if (a.start < b.start) return -1;
            if (a.start == b.start && a.end < b.end) return -1;
            if (a.start == b.start && a.end == b.end) return 0;

            return 1;
        });

        Interval prev = null;
        for (Interval x : xs) {
            if (prev == null) prev = x;
            else {
                if (isOverlap(prev, x)) {
                    prev = new Interval(Math.min(prev.start, x.start), Math.max(prev.end, x.end));
                } else {
                    result.add(prev);
                    prev = x;
                }
            }
        }
        result.add(prev);

        return result;
    }

    private boolean isOverlap(Interval a, Interval b) {
        return !(Math.max(a.start, b.start) > Math.min(a.end, b.end));
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
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
    }
}
