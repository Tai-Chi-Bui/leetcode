/*
 * Problem: 868. Binary Gap
 * 
 * Description:
 * Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n.
 * If there are no two adjacent 1's, return 0. Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
 * The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
 * 
 * Requirements:
 * - Find longest distance between adjacent 1's in binary representation
 * - Return 0 if no two adjacent 1's
 * - Return the maximum gap
 * 
 * Example:
 * Input: n = 22
 * Output: 2
 * Explanation: 22 in binary is "10110". The first adjacent pair of 1's is "10110" with a distance of 2. The second adjacent pair of 1's is "10110" with a distance of 1. The answer is the largest of these two distances, which is 2.
 * 
 * Constraints:
 * - 1 <= n <= 10^9
 */

class Solution {
    /*public int binaryGap(int n) {
        // Store Indexes
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }*/

    public int binaryGap(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                // Store max
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }
        return ans;
    }
}
