package td.problemsolving.interviewbit.MinCostPath;

import static td.problemsolving.utils.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Min Cost Path
 * https://www.interviewbit.com/problems/min-cost-path/
 */
public class Solution {
    public int solve(int a, int b, ArrayList<String> xs) {
        return dijkstraWithMinimalMemory(xs);
    }

    int dijkstraWithMinimalMemory(ArrayList<String> xs) {
        int[][] dp = new int[xs.size()][xs.get(0).length()];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        PriorityQueue<QueueItem2> queue = new PriorityQueue<>();
        queue.add(new QueueItem2(0, 0, 0));

        boolean[][] visited = new boolean[xs.size()][xs.get(0).length()];

        Object[][] dirs = new Object[][] {
                new Object[] { 'U', -1,  0 },
                new Object[] { 'D',  1,  0 },
                new Object[] { 'L',  0, -1 },
                new Object[] { 'R',  0,  1 },
        };

        while (!queue.isEmpty()) {
            QueueItem2 queueItem = queue.poll();
            while (!queue.isEmpty() && visited[queueItem.i][queueItem.j]) queueItem = queue.poll();
            visited[queueItem.i][queueItem.j] = true;

            for (Object[] dir : dirs) {
                int to_i = queueItem.i + (int)dir[1];
                int to_j = queueItem.j + (int)dir[2];

                if (to_i < 0 || to_j < 0 || to_i >= xs.size() || to_j >= xs.get(0).length()) continue;

                dp[to_i][to_j] = Math.min(
                        dp[to_i][to_j],
                        dp[queueItem.i][queueItem.j] + (xs.get(queueItem.i).charAt(queueItem.j) == (char)dir[0] ? 0 : 1)
                );

                if (!visited[to_i][to_j]) {
                    queue.add(new QueueItem2(to_i, to_j, dp[to_i][to_j]));
                }
            }

        }

//        print(dp);
//        printDp(graph, dp);

        return dp[xs.size() - 1][xs.get(0).length() - 1];
    }

    int dijkstra(Node[][] graph) {
        int[][] dp = new int[graph.length][graph[0].length];

        for (int[] xs : dp) {
            Arrays.fill(xs, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        PriorityQueue<QueueItem> queue = new PriorityQueue<>();
        queue.add(new QueueItem(graph[0][0], 0));

        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            QueueItem queueItem = queue.poll();
//            Edge edge = (Edge) queueItem;
            visited.add(queueItem.node);

            for (Edge edge : queueItem.node.edges) {
                dp[edge.to.i][edge.to.j] = Math.min(
                        dp[edge.to.i][edge.to.j],
                        dp[queueItem.node.i][queueItem.node.j] + edge.weight
                );

                if (!visited.contains(edge.to)) {
                    queue.add(new QueueItem(edge.to, dp[edge.to.i][edge.to.j]));
                }
            }
        }

//        printDp(graph, dp);

        return dp[graph.length - 1][graph[0].length - 1];
    }

    class QueueItem2 implements Comparable<QueueItem2> {
        int i;
        int j;
        int distance;

        public QueueItem2(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }

        @Override
        public int compareTo(QueueItem2 queueItem) {
            return Integer.compare(distance, queueItem.distance);
        }
    }

    class QueueItem implements Comparable<QueueItem> {
        Node node;
        int distance;

        public QueueItem(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(QueueItem queueItem) {
            return Integer.compare(distance, queueItem.distance);
        }
    }

    void printDp(Node[][] graph, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
//                System.out.printf("%d(%c) ", dp[i][j], graph[i][j].ch);
            }
            System.out.println();
        }
    }

    Node[][] createGraph(ArrayList<String> xs) {
        Node[][] graph = new Node[xs.size()][xs.get(0).length()];

        for (int i = 0; i < xs.size(); i++) {
            for (int j = 0; j < xs.get(i).length(); j++) {
                graph[i][j] = new Node(i, j);
            }
        }

        for (int i = 0; i < xs.size(); i++) {
            for (int j = 0; j < xs.get(i).length(); j++) {
                char ch = xs.get(i).charAt(j);

                if (i > 0) {
                    graph[i][j].edges.add(new Edge(graph[i - 1][j], ch == 'U' ? 0 : 1));
                }
                if (i < xs.size() - 1) {
                    graph[i][j].edges.add(new Edge(graph[i + 1][j], ch == 'D' ? 0 : 1));
                }
                if (j > 0) {
                    graph[i][j].edges.add(new Edge(graph[i][j - 1], ch == 'L' ? 0 : 1));
                }
                if (j < xs.get(i).length() - 1) {
                    graph[i][j].edges.add(new Edge(graph[i][j + 1], ch == 'R' ? 0 : 1));
                }
            }
        }

        return graph;
    }

    class Node {
        int i;
        int j;
        List<Edge> edges = new ArrayList<>();

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Node{" + "i=" + i + ", j=" + j + '}';
        }
    }

    class Edge implements Comparable<Edge> {
        Node to;
        int weight;

        public Edge(Node to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" + "to=" + to + ", weight=" + weight + '}';
        }

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(weight, edge.weight);
        }
    }
}
