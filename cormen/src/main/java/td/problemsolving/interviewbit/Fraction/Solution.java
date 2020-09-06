package td.problemsolving.interviewbit.Fraction;

import java.util.HashMap;
import java.util.Map;

/**
 * Fraction
 * https://www.interviewbit.com/problems/fraction/
 */
public class Solution {
    public String fractionToDecimal(int x, int y) {
        return fractionToDecimal((long)x, y);
    }

    public String fractionToDecimal(long x, long y) {
        String integer;
        if (x / y == 0 && (1. * x / y < 0)) {
            integer = "-" + x / y;
        } else {
            integer = String.valueOf(x / y);
        }

        x = x % y;

        x = Math.abs(x);
        y = Math.abs(y);

        int pos = 0;
        StringBuilder decimal = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();

        while (x > 0) {
            if (map.containsKey(x)) {
                String tmp = decimal.toString();
                decimal = new StringBuilder();
                decimal.append(tmp, 0, map.get(x));
                decimal.append("(");
                decimal.append(tmp, map.get(x), tmp.length());
                decimal.append(")");

                break;
            } else {
                map.put(x, pos++);
                x *= 10;
                long n = x / y;
                decimal.append(n);
                x = x % y;
            }
        }

        return integer + (!decimal.toString().equals("") ? "." + decimal : "");
    }
}
