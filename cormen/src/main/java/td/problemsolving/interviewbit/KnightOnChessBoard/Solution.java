package td.problemsolving.interviewbit.KnightOnChessBoard;

import java.util.*;

/**
 * Knight On Chess Board
 * https://www.interviewbit.com/problems/knight-on-chess-board/
 */
public class Solution {
    int[][] d = new int[][]{
            new int[]{-2,  1},
            new int[]{-1,  2},
            new int[]{ 1,  2},
            new int[]{ 2,  1},
            new int[]{ 2, -1},
            new int[]{ 1, -2},
            new int[]{-1, -2},
            new int[]{-2, -1},
    };

    public int knight(int A, int B, int C, int D, int E, int F) {
        return dijkstraSolution(A, B, C, D, E, F);
    }

    int dijkstraSolution(int A, int B, int C, int D, int E, int F) {
        if (C == E && D == F) return 0;

        Node[][] nodes = prepareGraph(A, B, C, D, E, F);
        Node from = nodes[C - 1][D - 1];
        Node to = nodes[E - 1][F - 1];

        Set<Node> visited = new HashSet<>();

        int[][] distances = new int[nodes.length][nodes[0].length];
        for (int[] row : distances) Arrays.fill(row, Integer.MAX_VALUE);
        distances[from.i][from.j] = 0;
        int[][][] path = new int[nodes.length][nodes[0].length][];

        PriorityQueue<QueueItem> queue = new PriorityQueue<>();
        queue.add(new QueueItem(from, distances[from.i][from.j]));

        while (!queue.isEmpty()) {
            QueueItem queueItem = queue.poll();
            while (!queue.isEmpty() && visited.contains(queueItem.node)) queueItem = queue.poll();

            for (Node neighbor : queueItem.node.neighbors) {
                if (!visited.contains(neighbor)) {
                    if (distances[queueItem.node.i][queueItem.node.j] + 1 < distances[neighbor.i][neighbor.j]) {
                        distances[neighbor.i][neighbor.j] = distances[queueItem.node.i][queueItem.node.j] + 1;
                        path[neighbor.i][neighbor.j] = new int[]{queueItem.node.i, queueItem.node.j};
                    }

                    if (neighbor.i == to.i && neighbor.j == to.j) {
                        printPath(path, to);

                        return distances[neighbor.i][neighbor.j];
                    }

                    queue.add(new QueueItem(neighbor, distances[neighbor.i][neighbor.j]));
                }
            }

            visited.add(queueItem.node);
        }

        return -1;
    }

    void printPath(int[][][] data, Node to) {
        Stack<int[]> stack = new Stack<>();

        int i = to.i;
        int j = to.j;

        while (data[i][j] != null) {
            stack.push(data[i][j]);
            int[] tmp = data[i][j];
            i = tmp[0];
            j = tmp[1];
        }

        while (!stack.isEmpty()) {
            int[] xs = stack.pop();
            System.out.printf("(%d,%d) ", xs[0], xs[1]);
        }

        System.out.printf("(%d,%d)\n", to.i, to.j);
    }

    class QueueItem implements Comparable<QueueItem> {
        Node node;
        int distance;

        public QueueItem(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(QueueItem o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    int bfsSolution(int A, int B, int C, int D, int E, int F) {
        Node[][] nodes = prepareGraph(A, B, C, D, E, F);

        return bfs(nodes[C - 1][D - 1], nodes[E - 1][F - 1]);
    }

    int bfs(Node from, Node to) {
        List<Node> levelNodes = new LinkedList<>();
        Set<Node> queued = new HashSet<>();
        levelNodes.add(from);
        queued.add(from);

        int level = 0;

        while (!levelNodes.isEmpty()) {
            List<Node> nextLevelNodes = new LinkedList<>();

            for (Node levelNode: levelNodes) {
                if (levelNode.i == to.i && levelNode.j == to.j) return level;

                for (Node neighbor : levelNode.neighbors) {
                    if (!queued.contains(neighbor)) {
                        nextLevelNodes.add(neighbor);
                        queued.add(neighbor);
                    }
                }
            }

            level++;
            levelNodes = nextLevelNodes;
        }

        return -1;
    }

    Node[][] prepareGraph(int A, int B, int C, int D, int E, int F) {
        Node[][] nodes = new Node[A][B];

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = new Node(i, j);
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                for (int k = 0; k < d.length; k++) {
                    int di = i + d[k][0];
                    int dj = j + d[k][1];

                    if (di >= 0 && dj >= 0 && di < A && dj < B) {
                        nodes[i][j].neighbors.add(nodes[di][dj]);
                    }
                }
            }
        }

        return nodes;
    }

    class Node {
        int i;
        int j;
        List<Node> neighbors = new ArrayList<>();

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
