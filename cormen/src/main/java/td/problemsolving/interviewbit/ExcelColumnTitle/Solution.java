package td.problemsolving.interviewbit.ExcelColumnTitle;

/**
 * Excel Column Title
 * https://www.interviewbit.com/problems/excel-column-title/
 */
public class Solution {
    public String convertToTitle(int x) {
        StringBuilder s = new StringBuilder();
        while (x > 0) {
            s.insert(0, (char) ('A' + ((x - 1) % 26)));
            x = (x - 1) / 26;
        }

        return s.toString();
    }
}
