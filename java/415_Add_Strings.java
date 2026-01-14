/*
 * Problem: 415. Add Strings
 * 
 * Description:
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * You must solve it without using any built-in BigInteger library or converting the inputs to integers directly.
 * 
 * Requirements:
 * - Add two numbers represented as strings
 * - Cannot use BigInteger or convert to integers
 * - Handle carry-over correctly
 * - Return result as string
 * 
 * Example:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * 
 * Constraints:
 * - 1 <= num1.length, num2.length <= 10^4
 * - num1 and num2 consist of only digits
 * - num1 and num2 don't contain any leading zero except for the zero itself
 */

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        // condition is great
        // https://leetcode.com/problems/add-strings/discuss/90436/Straightforward-Java-8-main-lines-25ms
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}