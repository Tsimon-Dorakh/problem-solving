package td.problemsolving.interviewbit.BinaryRepresentation;

/**
 * Binary Representation
 * https://www.interviewbit.com/problems/binary-representation/
 */
public class Solution {
    public String findDigitsInBinary(int x) {
        if (x == 0) return "0";

        StringBuilder result = new StringBuilder();

        while (x >= 1) {
            result.insert(0, x % 2);
            x /= 2;
        }

        return result.toString();
    }
}
