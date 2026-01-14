/*
 * Problem: 401. Binary Watch
 * 
 * Description:
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom
 * represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
 * Given an integer turnedOn which represents the number of LEDs that are currently on, return all possible
 * times the watch could represent. You may return the answer in any order.
 * 
 * Requirements:
 * - Find all possible times with given number of LEDs turned on
 * - Hours: 0-11, Minutes: 0-59
 * - Return list of strings in "H:MM" format
 * 
 * Example:
 * Input: turnedOn = 1
 * Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 
 * Constraints:
 * - 0 <= turnedOn <= 10
 */

class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times; 
    }
}
