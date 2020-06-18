package td.problemsolving.hackerearth.bucketsort.sort_the_array_5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClassTest {
    @Test
    void solve() {
        TestClass testClass = new TestClass();

        assertEquals(
                "1 3 5 2 4",
                testClass.solve(new int[]{1, 2, 3, 4, 5}, 2)
        );
    }
}
