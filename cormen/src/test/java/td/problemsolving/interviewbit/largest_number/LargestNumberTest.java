package td.problemsolving.interviewbit.largest_number;

import org.junit.jupiter.api.Test;
import td.problemsolving.leetcode.AddTwoNumbers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class LargestNumberTest {
    @Test
    void largestNumber() {
        assertEquals(
                "54321",
                new LargestNumber().largestNumber(new int[]{5, 4, 1, 3, 2})
        );

        assertEquals(
                "898",
                new LargestNumber().largestNumber(new int[]{89, 8})
        );

        assertEquals(
                "99197494093090589587787286882579979879178278077273570968668667867566465335024704093953663633573372982927126124019124113",
                new LargestNumber().largestNumber(new int[]{782, 240, 409, 678, 940, 502, 113, 686, 6, 825, 366, 686, 877, 357, 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363, 298, 470, 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905})
        );


        assertEquals(
                  "29829",
                new LargestNumber().largestNumber(new int[]{29, 298})
        );

        assertEquals(
                "9534330",
                new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9})
        );

        assertEquals(
                "0",
                new LargestNumber().largestNumber(new int[]{0, 0, 0, 0, 0})
        );

        assertEquals(
                "12121",
                new LargestNumber().largestNumber(new int[]{12, 121})
        );

    }
}
