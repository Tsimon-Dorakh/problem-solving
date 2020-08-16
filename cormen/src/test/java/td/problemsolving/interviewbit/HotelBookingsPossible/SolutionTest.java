package td.problemsolving.interviewbit.HotelBookingsPossible;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void hotel() {
        ArrayList<Integer> arrive;
        ArrayList<Integer> depart;

        arrive = new ArrayList<>(ImmutableList.of(9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27));
        depart = new ArrayList<>(ImmutableList.of(32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38));

        assertEquals(
                true,
                new Solution().hotel(arrive, depart, 16)
        );

        arrive = new ArrayList<>(ImmutableList.of(1, 5, 3));
        depart = new ArrayList<>(ImmutableList.of(2, 8, 6));

        assertEquals(
                false,
                new Solution().hotel(arrive, depart, 1)
        );


    }
}
