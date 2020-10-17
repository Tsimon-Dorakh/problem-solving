package td.problemsolving.interviewbit.CloneGraph;

import java.util.*;

/**
 * Clone Graph
 * https://www.interviewbit.com/problems/clone-graph/
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        Map<Integer, UndirectedGraphNode> clonedMap = new HashMap<>();

        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode graphNode = queue.pollFirst();
            clonedMap.put(graphNode.label, new UndirectedGraphNode(graphNode.label));

            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
                if (!clonedMap.containsKey(neighbor.label)) {
                    queue.addLast(neighbor);
                }
            }
        }

        Set<Integer> queued = new HashSet<>();
        queue.addLast(node);
        queued.add(node.label);

        while (!queue.isEmpty()) {
            UndirectedGraphNode graphNode = queue.pollFirst();

            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
                clonedMap.get(graphNode.label).neighbors.add(clonedMap.get(neighbor.label));

                if (!queued.contains(neighbor.label)) {
                    queue.addLast(neighbor);
                    queued.add(neighbor.label);
                }
            }
        }

        return clonedMap.get(node.label);
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "UndirectedGraphNode{" +
                    "label=" + label +
                    '}';
        }
    }
}
