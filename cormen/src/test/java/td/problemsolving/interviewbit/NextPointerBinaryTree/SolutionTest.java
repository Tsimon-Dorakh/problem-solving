package td.problemsolving.interviewbit.NextPointerBinaryTree;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeLinkNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void connect() {
        TreeLinkNode root;

        root = TreeLinkNode.createTree(new Integer[]{1, 2, 5, 3, 4, 6, 7});
        new Solution().connect(TreeLinkNode.createTree(new Integer[]{1, 2, 5, 3, 4, 6, 7}));
    }
}
