package td.problemsolving.interviewbit.RomanToInteger;

/**
 * Roman To Integer
 * https://www.interviewbit.com/problems/roman-to-integer/
 */
public class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;

        char[] xs = s.toCharArray();
        int i = xs.length - 1;
        int result = toInt(xs[i]);

        while (--i >= 0) {
            int x = toInt(xs[i]);
            if (toInt(xs[i]) < toInt(xs[i + 1])) x = -x;

            result += x;
        }

        return result;
    }

    private int toInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        throw new RuntimeException("Unsupported character");
    }
}
