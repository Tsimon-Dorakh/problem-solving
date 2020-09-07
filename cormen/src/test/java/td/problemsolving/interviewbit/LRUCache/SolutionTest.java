package td.problemsolving.interviewbit.LRUCache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void solution() {
        Solution cache = new Solution(2);
        cache.set(1, 10);
        cache.set(5, 12);
        assertEquals(12, cache.get(5));
        assertEquals(10, cache.get(1));
        assertEquals(-1, cache.get(10));
        cache.set(6, 14);
        assertEquals(-1, cache.get(5));
        assertEquals(14, cache.get(6));
    }
}
