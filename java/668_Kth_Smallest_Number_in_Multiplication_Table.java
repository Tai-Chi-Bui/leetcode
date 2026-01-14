/*
 * Problem: 668. Kth Smallest Number in Multiplication Table
 * 
 * Description:
 * Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer
 * matrix mat where mat[i][j] == i * j (1-indexed). Given three integers m, n, and k, return the kth
 * smallest element in the m x n multiplication table.
 * 
 * Requirements:
 * - Create a multiplication table of size m x n where mat[i][j] = i * j
 * - Find the kth smallest element in this table
 * - Return the kth smallest value
 * 
 * Example:
 * Input: m = 3, n = 3, k = 5
 * Output: 3
 * Explanation: The 5th smallest number is 3.
 * 
 * Constraints:
 * - 1 <= m, n <= 3 * 10^4
 * - 1 <= k <= m * n
 */

class Solution {
    // https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/solution/
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            // ith row [i, 2*i, 3*i, ..., n*i]
            // for each column, k = x // i
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }
}
