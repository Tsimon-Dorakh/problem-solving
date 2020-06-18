package td.problemsolving.hackerearth.bucketsort.tutorial;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TestClassTest {
    @Test
    void solve() {
        TestClass testClass = new TestClass();

        assertArrayEquals(
                new String[]{
                        "1 2 4",
                        "3 5",
                },
                testClass.solve(new int[]{1, 2, 3, 4, 5}).toArray()
        );
    }
}
