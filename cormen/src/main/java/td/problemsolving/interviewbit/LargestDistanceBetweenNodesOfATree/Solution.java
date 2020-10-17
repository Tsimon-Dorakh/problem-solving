package td.problemsolving.interviewbit.LargestDistanceBetweenNodesOfATree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Largest Distance between nodes of a Tree
 * https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
 */
public class Solution {
    int dist1 = 0;

    public int solve(int[] xs) {
        return solution2(xs);
    }

    int solution2(int[] xs) {
        Node[] nodes = new Node[xs.length];

        for (int i = 0; i < xs.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != -1) {
                nodes[i].neighbors.add(nodes[xs[i]]);
                nodes[xs[i]].neighbors.add(nodes[i]);
            }
        }

        bfs(nodes[0]);
        bfs(lastVisitedNode);

        return level;
    }

    Node lastVisitedNode = null;
    int level;

    void bfs(Node root) {
        lastVisitedNode = root;
        level = -1;
        List<Node> nodes = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        nodes.add(root);
        visited.add(root.id);

        while (!nodes.isEmpty()) {
            level++;
            List<Node> nextNodes = new ArrayList<>();

            for (Node node : nodes) {
                for (Node neighbor : node.neighbors) {
                    if (!visited.contains(neighbor.id)) {
                        lastVisitedNode = neighbor;

                        nextNodes.add(neighbor);
                        visited.add(neighbor.id);
                    }
                }
            }

            nodes = nextNodes;
        }
    }

    int solution1(int[] xs) {
        Node[] nodes = new Node[xs.length];
        Node root = null;

        for (int i = 0; i < xs.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] == -1) root = nodes[i];
            else {
                nodes[i].neighbors.add(nodes[xs[i]]);
                nodes[xs[i]].neighbors.add(nodes[i]);
            }
        }

        removeParent(root, null);

        root.maxDepth = getMaxDepth(root, 0);

        walk(root);

        return dist1;
    }

    void removeParent(Node node, Node parent) {
        node.neighbors.remove(parent);

        for (Node neighbor : node.neighbors) {
            removeParent(neighbor, node);
        }
    }

    void walk(Node node) {
        int depth1 = 0;
        int depth2 = 0;

        for (Node neighbor : node.neighbors) {
            walk(neighbor);

            if (neighbor.maxDepth > depth1) {
                depth2 = depth1;
                depth1 = neighbor.maxDepth;
            } else {
                depth2 = Math.max(depth2, neighbor.maxDepth);
            }
        }

        dist1 = Math.max(dist1, depth1 + depth2);
    }

    int getMaxDepth(Node node, int currDepth) {
        if (node.neighbors.size() == 0) {
            node.maxDepth = 0;

            return currDepth;
        }

        int maxNeighborsDepth = 0;

        for (Node neighbor : node.neighbors) {
            int neighborMaxDepth = getMaxDepth(neighbor, currDepth + 1);
            neighbor.maxDepth = neighborMaxDepth - currDepth;

            maxNeighborsDepth = Math.max(maxNeighborsDepth, neighborMaxDepth);
        }

        return maxNeighborsDepth;
    }

    class Node {
        int id;
        int maxDepth;
        List<Node> neighbors = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", maxDepth=" + maxDepth +
                    '}';
        }
    }

}
