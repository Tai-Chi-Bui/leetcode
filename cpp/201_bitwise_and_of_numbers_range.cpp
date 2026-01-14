/*
 * Problem: 201. Bitwise AND of Numbers Range
 * 
 * Description:
 * Given two integers left and right, return the bitwise AND of all numbers in this range, inclusive.
 * 
 * Requirements:
 * - Compute bitwise AND of all numbers from left to right (inclusive)
 * - Return the result
 * 
 * Example:
 * Input: left = 5, right = 7
 * Output: 4
 * Explanation: 
 * 5 = 101
 * 6 = 110
 * 7 = 111
 * AND = 100 = 4
 * 
 * Constraints:
 * - 0 <= left <= right <= 2^31 - 1
 */

/** time complexity : O(logN). N = min(m, n) **/

class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while(m < n) {
            m = m >> 1;
            n = n >> 1;
            cnt++;
        }
        return n<<cnt;
    }
};
