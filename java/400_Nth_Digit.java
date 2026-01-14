/*
 * Problem: 400. Nth Digit
 * 
 * Description:
 * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 * 
 * Requirements:
 * - Find the nth digit in the infinite sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * - Return the digit at position n
 * 
 * Example:
 * Input: n = 3
 * Output: 3
 * 
 * Input: n = 11
 * Output: 0
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * 
 * Constraints:
 * - 1 <= n <= 2^31 - 1
 */

class Solution {
    public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;
        // https://leetcode.com/problems/nth-digit/discuss/88363/Java-solution
		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}
		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
