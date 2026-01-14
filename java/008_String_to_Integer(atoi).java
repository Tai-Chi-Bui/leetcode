/*
 * Problem: 8. String to Integer (atoi)
 * 
 * Description:
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 * 
 * Requirements:
 * - Read in and ignore any leading whitespace
 * - Check if the next character (if not already at the end of the string) is '-' or '+'
 * - Read in next the characters until the next non-digit character or the end of the input is reached
 * - Convert these digits into an integer
 * - If the integer is out of the 32-bit signed integer range, clamp it to the range
 * - Return the integer as the final result
 * 
 * Example:
 * Input: s = "42"
 * Output: 42
 * 
 * Input: s = "   -42"
 * Output: -42
 * 
 * Constraints:
 * - 0 <= s.length <= 200
 * - s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'
 */

public class Solution {
	// example in leetcode book
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public int myAtoi(String str) {
    	int i = 0, n = str.length();
		while (i < n && Character.isWhitespace(str.charAt(i)))
			i++;
		int sign = 1;
		if (i < n && str.charAt(i) == '+')
			i++;
		else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		int num = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));
			if (num > maxDiv10 || num == maxDiv10 && digit >= 8)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			num = num * 10 + digit;
			i++;
		}
		return sign * num;    
    }
}