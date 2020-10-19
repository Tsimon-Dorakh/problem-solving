package td.problemsolving.interviewbit.WordLadderI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Word Ladder I
 * https://www.interviewbit.com/problems/word-ladder-i/
 */
public class Solution {
    public int solve(String from, String to, ArrayList<String> dict) {
        dict.add(0, from);
        dict.add(to);

        Map<String, Node> graph = createGraph(dict);

        List<Node> queue = new ArrayList<>();
        queue.add(graph.get(from));
        Set<Node> queued = new HashSet<>();
        queued.add(graph.get(from));

        int level = 0;
        while (!queue.isEmpty()) {
            List<Node> nextQueue = new ArrayList<>();

            for (Node node : queue) {
                for (Node neighbor : node.neighbors) {
                    if (neighbor.value.equals(to)) return level + 2;

                    if (!queued.contains(neighbor)) {
                        nextQueue.add(neighbor);
                        queued.add(neighbor);
                    }
                }
            }

            queue = nextQueue;
            level++;
        }

        return 0;
    }

    Map<String, Node> createGraph(ArrayList<String> dict) {
        Map<String, Node> graph = new HashMap<>();

        for (String word : dict) {
            graph.put(word, new Node(word));
        }

        for (String word : dict) {
            List<String> validTransformations = findValidTransformations(dict, word);

            for (String transformation : validTransformations) {
                graph.get(word).neighbors.add(graph.get(transformation));
            }
        }

        return graph;
    }

    List<String> findValidTransformations(ArrayList<String> dict, String from) {
        List<String> result = new ArrayList<>();

        for (String word : dict) {
            if (diff(word, from) == 1) result.add(word);
        }

        return result;
    }

    int diff(String x, String y) {
        int result = 0;

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) result++;
        }

        return result;
    }

    static class Node {
        String value;
        List<Node> neighbors = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "value='" + value + '\'' + '}';
        }
    }
}
