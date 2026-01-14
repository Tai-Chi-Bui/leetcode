/*
 * Problem: 1323. Maximum 69 Number
 * 
 * Description:
 * You are given a positive integer num consisting only of digits 6 and 9.
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 * 
 * Requirements:
 * - Change at most one digit
 * - 6 becomes 9, 9 becomes 6
 * - Return the maximum number possible
 * 
 * Example:
 * Input: num = 9669
 * Output: 9969
 * Explanation: Changing the first digit results in 6669. Changing the second digit results in 9969.
 * 
 * Constraints:
 * - 1 <= num <= 10^4
 * - num consists of only 6 and 9 digits
 */

class Solution {
    public int maximum69Number (int num) {
        // Replace first 6 with 9 if exists
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }

    /*
    public int maximum69Number (int num) {
        char[] chars = Integer.toString(num).toCharArray();
        // Replace first 6 with 9 if exists
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }*/
}
