package td.problemsolving.hackerrank.ctcicontacts;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void process() {
        List<List<String>> input;
        List<String> expected;

        input = ImmutableList.of(
                ImmutableList.of("add", "s"),
                ImmutableList.of("add", "ss"),
                ImmutableList.of("add", "sss"),
                ImmutableList.of("add", "ssss"),
                ImmutableList.of("add", "sssss"),
                ImmutableList.of("find", "s"),
                ImmutableList.of("find", "ss"),
                ImmutableList.of("find", "sss"),
                ImmutableList.of("find", "ssss"),
                ImmutableList.of("find", "sssss"),
                ImmutableList.of("find", "ssssss")
        );
        expected = ImmutableList.of(
                "5",
                "4",
                "3",
                "2",
                "1",
                "0"
        );
        assertEquals(expected, new Solution().process(input));

        input = ImmutableList.of(
                ImmutableList.of("add", "hack"),
                ImmutableList.of("add", "hackerrank"),
                ImmutableList.of("find", "hac"),
                ImmutableList.of("find", "hak")
        );
        expected = ImmutableList.of(
                "2",
                "0"
        );
        assertEquals(expected, new Solution().process(input));

//        System.out.println(String.join("\n", (new Solution().process(input))));
    }
}
