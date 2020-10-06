package td.problemsolving.interviewbit.MeetingRooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Meeting rooms
 * https://www.interviewbit.com/problems/meeting-rooms/
 */
public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> xss) {
        return ONLogNSolution(xss);
    }

    int ONLogNSolution(ArrayList<ArrayList<Integer>> xss) {
        int max = 0;
        PriorityQueue<ArrayList<Integer>> started = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(1)));

        xss.sort(Comparator.comparingInt(o -> o.get(0)));

        for (ArrayList<Integer> xs : xss) {
            while (started.size() > 0 && started.peek().get(1) <= xs.get(0)) started.poll();
            started.add(xs);

            max = Math.max(max, started.size());
        }

        return max;
    }

    int bruteForce(ArrayList<ArrayList<Integer>> xss) {
        int max = 0;

        xss.sort(Comparator.comparingInt(o -> o.get(0)));

        for (int i = 0; i < xss.size(); i++) {
            int current = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (overlap(xss.get(i), xss.get(j))) {
                    current++;
                }
            }

            max = Math.max(max, current);
        }

        return max;
    }


    boolean overlap(ArrayList<Integer> x, ArrayList<Integer> y) {
        return Math.max(x.get(0), y.get(0)) < Math.min(x.get(1), y.get(1));
    }
}
