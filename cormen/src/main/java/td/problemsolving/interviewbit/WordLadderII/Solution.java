package td.problemsolving.interviewbit.WordLadderII;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Word Ladder II
 * https://www.interviewbit.com/problems/word-ladder-ii/
 */
public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String from, String to, ArrayList<String> dict) {
        dict.add(from);
        dict.add(to);

        Map<String, Node> graph = createGraph(dict);
        int shortestDistance = getShortestDistance(graph, from, to);

        ArrayList<ArrayList<String>> paths = new ArrayList<>();

        if (shortestDistance >= 0) {
            Set<Node> visited = new HashSet<>();
            visited.add(graph.get(from));
            LinkedList<Node> path = new LinkedList<>();
            path.addLast(graph.get(from));

            fillPaths(paths, visited, path, shortestDistance, to);
        }

        return paths;
    }

    void fillPaths(ArrayList<ArrayList<String>> paths, Set<Node> visited, LinkedList<Node> path, int distance, String to) {
        if (distance < 0) return;
        if (distance == 0 && path.getLast().value.equals(to)) {
            paths.add(pathToString(path));
            return;
        }

        List<Node> neighbors = path.getLast().neighbors;
        for (Node neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                path.addLast(neighbor);
                visited.add(neighbor);

                fillPaths(paths, visited, path, distance - 1, to);

                visited.remove(neighbor);
                path.removeLast();
            }
        }
    }

    ArrayList<String> pathToString(LinkedList<Node> path) {
        ArrayList<String> result = new ArrayList<>();

        for (Node node : path) {
            result.add(node.value);
        }

        return result;
    }

    int getShortestDistance(Map<String, Node> graph, String from, String to) {
        if (from.equals(to)) return 0;

        List<Node> queue = new ArrayList<>();
        queue.add(graph.get(from));
        Set<Node> queued = new HashSet<>();
        queued.add(graph.get(from));

        int level = 0;
        while (!queue.isEmpty()) {
            List<Node> nextQueue = new ArrayList<>();

            for (Node node : queue) {
                for (Node neighbor : node.neighbors) {
                    if (neighbor.value.equals(to)) return level + 1;

                    if (!queued.contains(neighbor)) {
                        nextQueue.add(neighbor);
                        queued.add(neighbor);
                    }
                }
            }

            queue = nextQueue;
            level++;
        }

        return -1;
    }

    Map<String, Node> createGraph(Collection<String> dict) {
        Map<String, Node> graph = new HashMap<>();

        for (String word : dict) {
            graph.put(word, new Node(word));
        }

        for (String word : graph.keySet()) {
            Set<String> validTransformations = findValidTransformations(dict, word);

            for (String transformation : validTransformations) {
                graph.get(word).neighbors.add(graph.get(transformation));
            }
        }

        return graph;
    }

    Set<String> findValidTransformations(Collection<String> dict, String from) {
        Set<String> result = new HashSet<>();

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
