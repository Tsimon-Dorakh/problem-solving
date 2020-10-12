package td.problemsolving.interviewbit.Seats;

/**
 * Seats
 * https://www.interviewbit.com/problems/seats/
 */
public class Solution {
    public int seats(String s) {
        int first = s.length();
        int last = -1;
        int xCount = 0;
        int modulo = 10000003;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') {
                xCount++;
                if (first == s.length()) first = i;
                last = i;
            }
        }

        int midPos = 0;
        int ord = 0;
        for (int i = first; i <= last; i++) {
            if (s.charAt(i) == 'x') {
                if (xCount / 2 == ord) {
                    midPos = i;
                    break;
                }

                ord++;
            }
        }

        int count = 0;
        int dotCount = 0;
        for (int i = midPos - 1; i >= first; i--) {
            if (s.charAt(i) == '.') dotCount++;
            else {
                count += dotCount;
                count %= modulo;
            }
        }

        dotCount = 0;
        for (int i = midPos + 1; i <= last; i++) {
            if (s.charAt(i) == '.') dotCount++;
            else {
                count += dotCount;
                count %= modulo;
            }
        }

        return count;
    }
}
