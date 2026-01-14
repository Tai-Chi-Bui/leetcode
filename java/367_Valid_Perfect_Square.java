/*
 * Problem: 367. Valid Perfect Square
 * 
 * Description:
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 * A perfect square is an integer that is the square of an integer. In other words, it is the
 * product of some integer with itself.
 * 
 * Requirements:
 * - Check if a number is a perfect square
 * - Return true if perfect square, false otherwise
 * 
 * Example:
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * 
 * Constraints:
 * - 1 <= num <= 2^31 - 1
 */

class Solution {
    /* public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    } */

    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    /* public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    } */
}
