package td.problemsolving.interviewbit.NmaxPairCombinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * N max pair combinations
 * https://www.interviewbit.com/problems/n-max-pair-combinations/
 */
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        return OnSolution(xs, ys);
    }

    ArrayList<Integer> OnSolution(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Pair> visited = new HashSet<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(xs.get(b.x) + ys.get(b.y), xs.get(a.x) + ys.get(a.y)));

        xs.sort(Collections.reverseOrder());
        ys.sort(Collections.reverseOrder());

        heap.add(new Pair(0, 0));

        while (result.size() < xs.size()) {
            Pair pair = heap.poll();
            result.add(xs.get(pair.x) + ys.get(pair.y));

            Pair newPair;

            if (pair.x + 1 < xs.size()) {
                newPair = new Pair(pair.x + 1, pair.y);
                if (!visited.contains(newPair)) {
                    visited.add(newPair);
                    heap.add(newPair);
                }
            }

            if (pair.y + 1 < xs.size()) {
                newPair = new Pair(pair.x, pair.y + 1);
                if (!visited.contains(newPair)) {
                    visited.add(newPair);
                    heap.add(newPair);
                }
            }
        }

        return result;
    }

    static class Pair {
        Integer x;
        Integer y;

        public Pair() {
        }

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Pair pair = (Pair) o;

            if (x != null ? !x.equals(pair.x) : pair.x != null)
                return false;
            return y != null ? y.equals(pair.y) : pair.y == null;
        }

        @Override
        public int hashCode() {
            int result = x != null ? x.hashCode() : 0;
            result = 31 * result + (y != null ? y.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
        }
    }

    ArrayList<Integer> OnSquareSolution2(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        PriorityQueue<Integer> set = new PriorityQueue<>();

        for (int i = 0; i < xs.size(); i++) {
            for (int j = 0; j < xs.size(); j++) {
                set.add(xs.get(i) + ys.get(j));

                if (set.size() > xs.size()) {
                    set.poll();
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        Collections.reverse(result);

        return result;
    }

    ArrayList<Integer> OnSquareSolution(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < xs.size(); i++) {
            for (int j = 0; j < xs.size(); j++) {
                result.add(xs.get(i) + ys.get(j));
            }
        }

        Collections.sort(result);
        Collections.reverse(result);

        return new ArrayList<>(result.subList(0, xs.size()));
    }
}
