package td.problemsolving.interviewbit.CloneGraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void cloneGraph() {
        Solution.UndirectedGraphNode node;
        Solution.UndirectedGraphNode expected;

        Solution.UndirectedGraphNode node1 = new Solution.UndirectedGraphNode(703);
        Solution.UndirectedGraphNode node2 = new Solution.UndirectedGraphNode(279);
        Solution.UndirectedGraphNode node3 = new Solution.UndirectedGraphNode(43);
        node1.neighbors.add(node1);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node2);
        node2.neighbors.add(node3);

        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
//        node.neighbors.add(new Solution.UndirectedGraphNode(2));

        new Solution().cloneGraph(node1);

    }
}
