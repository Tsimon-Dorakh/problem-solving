package td.problemsolving.interviewbit.WordSearchBoard;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void exist() {
        ArrayList<String> xs;
        String s;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(
                "FEDCBECD",
                "FABBGACG",
                "CDEDGAEC",
                "BFFEGGBA",
                "FCEEAFDA",
                "AGFADEAC",
                "ADGDCBAA",
                "EAABDDFF"
        ));
        s = "BCDCB";
        expected = 1;
        assertEquals(expected, new Solution().exist(xs, s));

        xs = new ArrayList<>(ImmutableList.of(
                "ABCE",
                "SFCS",
                "ADEE"
        ));
        s = "ABCCED";
        expected = 1;
        assertEquals(expected, new Solution().exist(xs, s));

        xs = new ArrayList<>(ImmutableList.of(
                "ABCE",
                "SFCS",
                "ADEE"
        ));
        s = "ABCD";
        expected = 0;
        assertEquals(expected, new Solution().exist(xs, s));

        xs = new ArrayList<>(ImmutableList.of(
                "ABCE",
                "SFCS",
                "ADEE"
        ));
        s = "SEE";
        expected = 1;
        assertEquals(expected, new Solution().exist(xs, s));
    }
}
