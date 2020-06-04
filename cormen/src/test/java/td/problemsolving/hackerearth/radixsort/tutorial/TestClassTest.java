package td.problemsolving.hackerearth.radixsort.tutorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClassTest {
    @Test
    void solve() {
        TestClass testClass = new TestClass();

        assertArrayEquals(
            new String[]{
                "170 90 802 2 24 45 75 66",
                "802 2 24 45 66 170 75 90",
                "2 24 45 66 75 90 170 802"
            },
            testClass.solve(new int[]{170, 45, 75, 90, 802, 24, 2, 66}).toArray()
        );
    }
}
