package td.problemsolving.interviewbit.Fraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fractionToDecimal() {
        assertEquals("2.(1017811704834605597964376590330788804071246819338422391857506361323155216284987277353689567430025445292620865139949109414758269720)", new Solution().fractionToDecimal(826, 393));
        assertEquals("0.0000000004656612873077392578125", new Solution().fractionToDecimal(-1, -2147483648));
        assertEquals("-1.5", new Solution().fractionToDecimal(-3, 2));
        assertEquals("0", new Solution().fractionToDecimal(0, -1));
        assertEquals("-0.5", new Solution().fractionToDecimal(-1, 2));
        assertEquals("2147483648", new Solution().fractionToDecimal(-2147483648, -1));
        assertEquals("0.(6)", new Solution().fractionToDecimal(2, 3));
        assertEquals("0.5", new Solution().fractionToDecimal(1, 2));
        assertEquals("2", new Solution().fractionToDecimal(2, 1));

    }
}
