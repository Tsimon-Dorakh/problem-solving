package td.problemsolving.hackerearth.radixsort.monk_and_sorting_algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClassTest {
    @Test
    void solve() {
        TestClass testClass = new TestClass();

        assertArrayEquals(
                new String[]{
                        "213456789 123456789 167890",
                        "167890 123456789 213456789",
                },
                testClass.solve(new long[]{213456789, 167890, 123456789}).toArray()
        );
    }
}
