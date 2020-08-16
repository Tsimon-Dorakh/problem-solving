package td.problemsolving.interviewbit.HotelBookingsPossible;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Hotel Bookings Possible
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 */
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        return neatSolution(arrive, depart, K);
    }

    public boolean neatSolution(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);

        for (int i = K; i < arrive.size(); i++) {
            if (arrive.get(i) < depart.get(i - K)) {
                return false;
            }
        }

        return true;
    }

    public boolean mySolution(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        ArrayList<ArrayList<Integer>> xss = new ArrayList<>();

        for (int i = 0; i < arrive.size(); i++) {
            ArrayList<Integer> cell;

            cell = new ArrayList<>();
            cell.add(arrive.get(i));
            cell.add(1);

            xss.add(cell);

            cell = new ArrayList<>();
            cell.add(depart.get(i));
            cell.add(0);

            xss.add(cell);
        }

        xss.sort((xs, ys) -> {
            if (xs.get(0) < ys.get(0)) return -1;
            if (xs.get(0).equals(ys.get(0)) && xs.get(1) < ys.get(1)) return -1;
            if (xs.get(0).equals(ys.get(0)) && xs.get(1).equals(ys.get(1))) return 0;

            return 1;
        });

        int arrived = 0;
        for (ArrayList<Integer> xs : xss) {
            if (xs.get(1) == 1) arrived++;
            else arrived--;

            if (arrived > K) return false;
        }

        return true;
    }

}
