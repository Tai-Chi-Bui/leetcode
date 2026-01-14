/*
 * Problem: 1981. Minimize the Difference Between Target and Chosen Elements
 * 
 * Description:
 * You are given an m x n integer matrix mat and an integer target.
 * Choose one element from each row in the matrix such that the absolute difference
 * between target and the sum of the chosen elements is minimized.
 * Return the minimum absolute difference.
 * 
 * Requirements:
 * - Choose one element from each row
 * - Minimize absolute difference between target and sum of chosen elements
 * - Return the minimum absolute difference
 * 
 * Example:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
 * Output: 0
 * Explanation: One possible choice is to: 1 + 5 + 7 = 13. The absolute difference is 0.
 * 
 * Constraints:
 * - m == mat.length
 * - n == mat[i].length
 * - 1 <= m, n <= 70
 * - 1 <= mat[i][j] <= 70
 * - 1 <= target <= 800
 */

class Solution {
    public int minimizeTheDifference(int[][] a, int k) {
        n = a.length;
        m = a[0].length;
        min = Integer.MAX_VALUE;
        dp = new boolean[n][5000];
        solve(a, k, 0, 0, 0);
        return min;
    }

    private void solve(int a[][], int k, int sum, int row, int col) {
        if (dp[row][sum])
            return;
        if (n - 1 == row) {
            for (int i = 0; i < m; i++)
                min = Math.min(min, Math.abs(k - sum - a[row][i]));
            dp[row][sum] = true;
            return;
        }

        for (int i = 0; i < m; i++)
            solve(a, k, sum + a[row][i], row + 1, col);
        dp[row][sum] = true;
    }

    private int min;
    private int dy[], n, m;
    private boolean dp[][];
}
