package td.problemsolving.hackerearth.countingsort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TutorialTest {
    @Test
    void solve() {
        assertArrayEquals(
                new String[]{"1 1", "2 1", "3 1", "4 1", "5 1"},
                new Tutorial().solve(new int[]{5,4,3,2,1}).toArray()
        );
    }
}
