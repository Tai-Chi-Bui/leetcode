/*
 * Problem: 717. 1-bit and 2-bit Characters
 * 
 * Description:
 * We have two special characters:
 * - The first character can be represented by one bit 0
 * - The second character can be represented by two bits (10 or 11)
 * Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
 * 
 * Requirements:
 * - Determine if last character is one-bit character (0)
 * - Array always ends with 0
 * - Return true if last character is one-bit, false otherwise
 * 
 * Example:
 * Input: bits = [1, 0, 0]
 * Output: true
 * Explanation: The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * 
 * Input: bits = [1, 1, 1, 0]
 * Output: false
 * Explanation: The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * 
 * Constraints:
 * - 1 <= bits.length <= 1000
 * - bits[i] is either 0 or 1
 */

// https://leetcode.com/problems/1-bit-and-2-bit-characters/solution/
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int pos = 0;
        // Go through bits
        while (pos < bits.length - 1) {
            // if 1, pos + 2; if 0, pos + 1
            pos += bits[pos] + 1;
        }
        return pos == bits.length - 1;
    }

    /* public boolean isOneBitCharacter(int[] bits) {
        // From len - 2
        int i = bits.length - 2;
        // until encounter 0
        while (i >= 0 && bits[i] > 0) i--;
        // check if second last zero is even
        return (bits.length - i) % 2 == 0;
    } */
}
