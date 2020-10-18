package td.problemsolving.interviewbit.ConvertSortedListToBinarySearchTree;

import org.junit.jupiter.api.Test;
import td.problemsolving.interviewbit.common.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortedListToBST() {
        Solution.ListNode a;
        TreeNode expected;

        Solution.ListNode a1;
        Solution.ListNode a2;
        Solution.ListNode a3;

        a1 = new Solution.ListNode(1);
        a2 = new Solution.ListNode(2);
        a1.next = a2;
        a = a1;
        expected = TreeNode.createTree(new Integer[]{1, null, 2});
        assertEquals(expected, new Solution().sortedListToBST(a));

        a1 = new Solution.ListNode(1);
        a2 = new Solution.ListNode(2);
        a3 = new Solution.ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a = a1;
        expected = TreeNode.createTree(new Integer[]{2, 1, 3});
        assertEquals(expected, new Solution().sortedListToBST(a));
    }
}
