package td.problemsolving.interviewbit.CommutableIslands;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Commutable Islands
 * https://www.interviewbit.com/problems/commutable-islands/
 */
public class Solution {
    public int solve(int a, int[][] xss) {
        return krushkalsAlgorithm(a, xss);
    }

    int krushkalsAlgorithm(int a, int[][] xss) {
        DisjointSet disjointSet = new DisjointSet(a + 1);
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();

        for (int[] xs : xss) {
            minHeap.add(new Edge(xs[0], xs[1], xs[2]));
        }

        int edges = 0;
        int path = 0;
        while (edges < a - 1) {
            Edge edge = minHeap.poll();

            if (disjointSet.find(edge.from) != disjointSet.find(edge.to)) {
                edges++;
                path += edge.dist;
                disjointSet.union(edge.from, edge.to);
            }
        }

        return path;
    }

    class DisjointSet {
        int[] data;

        DisjointSet(int size) {
            data = new int[size];
            Arrays.fill(data, -1);
        }

        int find(int x) {
            if (data[x] < 0) return x;

            return data[x] = find(data[x]);
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (data[px] <= data[py]) {
                data[px] += data[py];
                data[py] = px;
            } else {
                data[py] += data[px];
                data[px] = py;
            }
        }

        @Override
        public String toString() {
            return "DisjointSet{" + "data=" + Arrays.toString(data) + '}';
        }
    }

    public int prim(int a, int[][] xss) {
        int[][] map = new int[a + 1][a + 1];

        for (int[] xs : xss) {
            map[xs[0]][xs[1]] = map[xs[1]][xs[0]] = xs[2];
        }

        Set<Integer> visited = new HashSet<>();
        Set<Edge> tracked = new HashSet<>();
        int from = xss[0][0];
        visited.add(from);

        PriorityQueue<Edge> heap = new PriorityQueue<>();
        int path = 0;

        while (visited.size() < a) {
            for (int to = 1; to < map[from].length; to++) {
                if (visited.contains(to)) continue;
                if (map[from][to] == 0) continue;

                Edge edge = new Edge(from, to, map[from][to]);
                if (!tracked.contains(edge)) {
                    tracked.add(edge);
                    heap.add(edge);
                }
            }

            Edge nextEdge = heap.poll();
            tracked.remove(nextEdge);
            while (visited.contains(nextEdge.to)) {
                nextEdge = heap.poll();
                tracked.remove(nextEdge);
            }

            from = nextEdge.to;
            path += nextEdge.dist;
            visited.add(from);
        }

        return path;
    }

    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int dist;

        Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Edge edge = (Edge) o;

            if (from != edge.from)
                return false;
            if (to != edge.to)
                return false;
            return dist == edge.dist;
        }

        @Override
        public int hashCode() {
            int result = from;
            result = 31 * result + to;
            result = 31 * result + dist;
            return result;
        }

        @Override
        public int compareTo(Edge that) {
            return Integer.compare(this.dist, that.dist);
        }
    }
}
