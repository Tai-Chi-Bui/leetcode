/*
 * Problem: 7. Reverse Integer
 * 
 * Description:
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
 * then return 0.
 * 
 * Requirements:
 * - Reverse the digits of an integer
 * - Handle overflow: return 0 if reversed number is outside 32-bit integer range
 * - Preserve the sign of the number
 * 
 * Example:
 * Input: x = 123
 * Output: 321
 * 
 * Input: x = -123
 * Output: -321
 * 
 * Constraints:
 * - -2^31 <= x <= 2^31 - 1
 */

class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int) res;
    }
}