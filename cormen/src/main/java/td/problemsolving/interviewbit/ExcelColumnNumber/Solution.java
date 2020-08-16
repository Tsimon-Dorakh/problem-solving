package td.problemsolving.interviewbit.ExcelColumnNumber;

/**
 * Excel Column Number
 * https://www.interviewbit.com/problems/excel-column-number/
 */
public class Solution {
    public int titleToNumber(String s) {
        int APos = 'A';
        char[] xs = s.toCharArray();

        int result = 0;
        for (int i = 0; i < xs.length; i++) {
            result += (xs[i] - APos + 1) * Math.pow(26,(xs.length - i - 1));
        }

        return result;
    }
}
