package td.problemsolving.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        int[] nums;
        int[] expected;
        int target;

        nums = new int[]{2, 7, 11, 15};
        expected = new int[]{0, 1};
        target = 9;
        assertEquals(expected, new TwoSum().twoSum(nums, target));

        nums = new int[]{3, 2, 4};
        expected = new int[]{1, 2};
        target = 6;
        assertEquals(expected, new TwoSum().twoSum(nums, target));
    }
}
