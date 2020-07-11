package td.problemsolving.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbersTest {
    @Test
    void testAddTwoNumbers() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        AddTwoNumbers.ListNode listNode1 = AddTwoNumbers.ListNode.createListNode(new int[]{2, 4, 3});
        AddTwoNumbers.ListNode listNode2 = AddTwoNumbers.ListNode.createListNode(new int[]{5, 6, 4});

        AddTwoNumbers.ListNode sum = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        AddTwoNumbers.ListNode.print(sum);

        assertEquals(
                AddTwoNumbers.ListNode.createListNode(new int[]{7, 0, 8}),
                sum
        );
        assertEquals(
                addTwoNumbers.addTwoNumbers(
                        AddTwoNumbers.ListNode.createListNode(new int[]{5, 5, 5}),
                        AddTwoNumbers.ListNode.createListNode(new int[]{5, 5, 5})
                ),
                AddTwoNumbers.ListNode.createListNode(new int[]{0, 1, 1, 1})
        );
    }
}
