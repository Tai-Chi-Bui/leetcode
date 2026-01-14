/*
 * Problem: 13. Roman to Integer
 * 
 * Description:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Convert a Roman numeral to an integer.
 * 
 * Requirements:
 * - Convert Roman numeral string to integer
 * - Handle subtraction cases (IV, IX, XL, XC, CD, CM)
 * 
 * Example:
 * Input: s = "III"
 * Output: 3
 * 
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * Constraints:
 * - 1 <= s.length <= 15
 * - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * - It is guaranteed that s is a valid roman numeral in the range [1, 3999]
 */

class Solution {
    public int romanToInt(String s) {
        int[] arr = new int['A' + 26];
        arr['I'] = 1;
        arr['V'] = 5;
        arr['X'] = 10;
        arr['L'] = 50;
        arr['C'] = 100;
        arr['D'] = 500;
        arr['M'] = 1000;

        int result = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = arr[s.charAt(i)];
            result += prev > current ? -current : current;
            prev = current;
        }

        return result;
    }
}