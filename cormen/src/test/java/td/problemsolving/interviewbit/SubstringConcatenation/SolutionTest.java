package td.problemsolving.interviewbit.SubstringConcatenation;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findSubstring() {
        List<String> xs;
        ArrayList<Integer> expected;

        xs = ImmutableList.of("aa", "ac", "ac", "bb", "bb", "bb", "ac");
        expected = new ArrayList<>(ImmutableList.of());
        assertEquals(expected, new Solution().findSubstring("aaacabbbcccccacacbbac", xs));

        xs = ImmutableList.of("foo", "bar");
        expected = new ArrayList<>(ImmutableList.of(0, 9));
        assertEquals(expected, new Solution().findSubstring("barfoothefoobarman", xs));


//        xs = ImmutableList.of("cabccbbbc", "abbccabbc", "bbbcbbbaa", "acbaabcab", "ccacabccb", "bbacaabca", "acacbaacb", "aabbcccab", "ccccbbcaa", "baaccaabc");
//        expected = new ArrayList<>(ImmutableList.of(0,9));
//        assertEquals(expected, new Solution().findSubstring("acaaacbcbccbaabaccabcbbcaaccbbbbcbabaacbbcbccababb", xs));

    }
}
