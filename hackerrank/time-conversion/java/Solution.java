/**
 * Time Conversion
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-time-conversion/problem
 */
public class Solution {
    public static String timeConversion(String s) {
        String[] time = s.substring(0, 8).split(":");
        String part = s.substring(8);

        if (part.equals("AM")) {
            if (time[0].equals("12")) {
                time[0] = "00";
            }
        } else {
            int hour = Integer.parseInt(time[0]);
            if (hour < 12) {
                hour += 12;
            }
            time[0] = String.format("%02d", hour);
        }

        return String.format("%s:%s:%s", time[0], time[1], time[2]);
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:00:00AM"));
        System.out.println(timeConversion("12:00:00PM"));
        System.out.println(timeConversion("07:05:45PM"));
    }

}
