package td.problemsolving.cormen.countingsort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IndexTest {
    @Test
    void create() {
        Index index = Index.create(new int[]{1,2,2,3,4,5}, 5);

        assertEquals(3, index.query(2, 3));
        assertEquals(6, index.query(1, 5));
        assertEquals(2, index.query(2, 2));
    }
}
