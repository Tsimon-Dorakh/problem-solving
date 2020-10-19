package td.problemsolving.interviewbit.PossibilityOfFinishingAllCoursesGivenPreRequisites;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Possibility of finishing all courses given pre-requisites
 * https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
 */
public class Solution {
    public int solve(int A, int[] B, int[] C) {
        Map<Integer, Node> graph = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            graph.put(B[i], new Node(B[i]));
            graph.put(C[i], new Node(C[i]));
        }

        for (int i = 0; i < B.length; i++) {
            graph.get(B[i]).neighbors.add(graph.get(C[i]));
        }

        Boolean[] dp = new Boolean[A + 1];
        boolean result = false;
        for (Node node : graph.values()) {
            result = result | hasCycle(dp, new boolean[A + 1], node);
        }

        return result ? 0 : 1;
    }

    boolean hasCycle(Boolean[] dp, boolean[] visited, Node node) {
        if (visited[node.label]) return true;

        if (dp[node.label] == null) {
            dp[node.label] = false;

            visited[node.label] = true;
            for (Node neighbor : node.neighbors) {
                dp[node.label] = dp[node.label] | hasCycle(dp, visited, neighbor);
            }
            visited[node.label] = false;
        }

        return dp[node.label];
    }

    class Node {
        int label;
        List<Node> neighbors = new ArrayList<>();

        public Node(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Node{" + "label=" + label + '}';
        }
    }
}
