package td.problemsolving.leetcode.CourseScheduleII;

import java.util.*;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class Solution {
    public int[] findOrder(int n, int[][] xss) {
        Node[] graph = new Node[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new Node(i);
        }

        for (int[] xs: xss) {
            graph[xs[1]].neighbours.add(graph[xs[0]]);
            graph[xs[0]].inDegree++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Node node: graph) {
            if (node.inDegree == 0) {
                queue.add(node.id);
            }
        }

        boolean[] queued = new boolean[n];
        List<Integer> res = new ArrayList<>(n);

        while (!queue.isEmpty()) {
            Integer nodeId = queue.poll();

            res.add(nodeId);
            for (Node neighbour: graph[nodeId].neighbours) {
                if (!queued[neighbour.id]) {
                    neighbour.inDegree--;
                    if (neighbour.inDegree == 0) {
                        queue.add(neighbour.id);
                        queued[neighbour.id] = true;
                    }
                }
            }
        }

        if (res.size() < n) {
            return new int[0];
        }

        return toArray(res);
    }

    int[] toArray(List<Integer> xs) {
        int[] ys = new int[xs.size()];

        for (int i = 0; i < xs.size(); i++) {
            ys[i] = xs.get(i);
        }

        return ys;
    }

    class Node {
        int id;
        List<Node> neighbours = new LinkedList<>();
        int inDegree = 0;

        Node(int id) {
            this.id = id;
        }
    }
}
