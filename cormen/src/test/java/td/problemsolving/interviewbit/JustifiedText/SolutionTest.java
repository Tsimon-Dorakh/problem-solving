package td.problemsolving.interviewbit.JustifiedText;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fullJustify() {
        ArrayList<String> input;
        ArrayList<String> expected;

        input = new ArrayList<>(ImmutableList.of("am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui"));
        expected = new ArrayList<>(ImmutableList.of("am    fasgoprn", "lvqsrjylg     ", "rzuslwan xlaui"));
        assertEquals(expected, new Solution().fullJustify(input, 14));

        input = new ArrayList<>(ImmutableList.of("This", "is", "an", "example", "of", "text", "justification."));
        expected = new ArrayList<>(ImmutableList.of("This    is    an", "example  of text", "justification.  "));
        assertEquals(expected, new Solution().fullJustify(input, 16));

        input = new ArrayList<>(ImmutableList.of("glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m"));
        expected = new ArrayList<>(ImmutableList.of(
                "glu  muskzjyen  ahxkp  t  djmgzzyh  jzudvh  raji  vmipiz  sg rv mekoexzfmq fsrihvdnt yvnppem gidia fxjlzekp uvdaj ua pzagn bjffryz nkdd osrownxj",
                "fvluvpdj  kkrpr  khp  eef aogrl gqfwfnaen qhujt vabjsmj ji f opihimudj awi jyjlyfavbg tqxupaaknt dvqxay ny ezxsvmqk ncsckq nzlce cxzdirg dnmaxql",
                "bhrgyuyc qtqt yka wkjriv xyfoxfcqzb fttsfs m                                                                                                    "));
        assertEquals(expected, new Solution().fullJustify(input, 144));


        input = new ArrayList<>(ImmutableList.of("What", "must", "be", "shall", "be."));
        expected = new ArrayList<>(ImmutableList.of("What must be", "shall be.   "));
        assertEquals(expected, new Solution().fullJustify(input, 12));




    }
}
