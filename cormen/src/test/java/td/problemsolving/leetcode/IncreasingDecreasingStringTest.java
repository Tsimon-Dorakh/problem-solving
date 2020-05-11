package td.problemsolving.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class IncreasingDecreasingStringTest {
    @Test
    void sortString() {
        assertEquals("abccbaabccba", new IncreasingDecreasingString().sortString("aaaabbbbcccc"));
        assertEquals("art", new IncreasingDecreasingString().sortString("rat"));
        assertEquals("cdelotee", new IncreasingDecreasingString().sortString("leetcode"));
        assertEquals("ggggggg", new IncreasingDecreasingString().sortString("ggggggg"));
        assertEquals("ops", new IncreasingDecreasingString().sortString("spo"));
    }
}
