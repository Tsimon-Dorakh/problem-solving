package td.problemsolving.interviewbit.KnightOnChessBoard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void knight() {
        int A;
        int B;
        int C;
        int D;
        int E;
        int F;
        int expected;

        A = 8;
        B = 8;
        C = 1;
        D = 1;
        E = 8;
        F = 8;
        expected = 6;
        assertEquals(expected, new Solution().knight(A, B, C, D, E, F));

        A = 1;
        B = 1;
        C = 1;
        D = 1;
        E = 1;
        F = 1;
        expected = 0;
        assertEquals(expected, new Solution().knight(A, B, C, D, E, F));
        
        A = 2;
        B = 20;
        C = 1;
        D = 18;
        E = 1;
        F = 5;
        expected = -1;
        assertEquals(expected, new Solution().knight(A, B, C, D, E, F));

        A = 4;
        B = 7;
        C = 2;
        D = 6;
        E = 2;
        F = 4;
        expected = 2;
        assertEquals(expected, new Solution().knight(A, B, C, D, E, F));


    }
}
