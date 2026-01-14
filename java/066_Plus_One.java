/*
 * Problem: 66. Plus One
 * 
 * Description:
 * You are given a large integer represented as an integer array digits, where each digits[i]
 * is the ith digit of the integer. The digits are ordered from most significant to least
 * significant in left-to-right order. The large integer does not contain any leading zeros.
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * Requirements:
 * - Add one to the number represented by the digits array
 * - Handle carry-over when digits[i] == 9
 * - Return the result as an array of digits
 * 
 * Example:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124.
 * 
 * Constraints:
 * - 1 <= digits.length <= 100
 * - 0 <= digits[i] <= 9
 * - digits does not contain any leading zeros
 */

class Solution {
    public int[] plusOne(int[] digits) {
            return addToDigit(digits, digits.length - 1);
        }

        private int[] addToDigit(int[] digits, int index) {
            if (index == -1) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    newDigits[i + 1] = digits[i];
                }
                return newDigits;
            }
            if (digits[index] == 9) {
                digits[index] = 0;
                return addToDigit(digits, index - 1);
            } else {
                digits[index]++;
                return digits;
            }
        }
}
