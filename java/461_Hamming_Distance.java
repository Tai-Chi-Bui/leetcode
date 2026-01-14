/*
 * Problem: 461. Hamming Distance
 * 
 * Description:
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 * 
 * Requirements:
 * - Calculate Hamming distance between two integers
 * - Hamming distance is number of different bits
 * - Return the distance
 * 
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * 
 * Constraints:
 * - 0 <= x, y <= 2^31 - 1
 */

class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}