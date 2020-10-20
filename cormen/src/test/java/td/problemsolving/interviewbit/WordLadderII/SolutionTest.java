package td.problemsolving.interviewbit.WordLadderII;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void findLadders() {
        String from;
        String to;
        ArrayList<String> dict;
        ArrayList<ArrayList<String>> expected;

        from = "bbaa";
        to = "babb";
        dict = new ArrayList<>(ImmutableList.of("baba", "abba", "aaba", "bbbb", "abaa", "abab", "aaab", "abba", "abba", "abba", "bbba", "aaab", "abaa", "baba", "baaa", "bbaa", "babb"));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of("bbaa", "baaa", "baba", "babb")),
                new ArrayList<>(ImmutableList.of("bbaa", "bbba", "baba", "babb")),
                new ArrayList<>(ImmutableList.of("bbaa", "bbba", "bbbb", "babb"))
        ));
        assertEquals(expected, new Solution().findLadders(from, to, dict));

        from = "bb";
        to = "bb";
        dict = new ArrayList<>(ImmutableList.of("bb"));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of("bb"))
        ));
        assertEquals(expected, new Solution().findLadders(from, to, dict));

        from = "bb";
        to = "ab";
        dict = new ArrayList<>(ImmutableList.of("bb", "ab"));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of("bb", "ab"))
        ));
        assertEquals(expected, new Solution().findLadders(from, to, dict));

        from = "hit";
        to = "cog";
        dict = new ArrayList<>(ImmutableList.of("hot", "dot", "dog", "lot", "log"));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of("hit", "hot", "dot", "dog", "cog")),
                new ArrayList<>(ImmutableList.of("hit", "hot", "lot", "log", "cog"))
        ));
        assertEquals(expected, new Solution().findLadders(from, to, dict));
    }
}
