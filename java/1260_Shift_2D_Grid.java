/*
 * Problem: 1260. Shift 2D Grid
 * 
 * Description:
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 * In one shift operation:
 * - Element at grid[i][j] moves to grid[i][j + 1]
 * - Element at grid[i][n - 1] moves to grid[i + 1][0]
 * - Element at grid[m - 1][n - 1] moves to grid[0][0]
 * Return the 2D grid after applying k shift operations.
 * 
 * Requirements:
 * - Shift grid k times (right and down, wrapping around)
 * - Return the shifted grid as a list of lists
 * 
 * Example:
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 * 
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m <= 50
 * - 1 <= n <= 50
 * - -1000 <= grid[i][j] <= 1000
 * - 0 <= k <= 100
 */

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] newGrid = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        // Compute final move
        int true_k = k % (m * n);
        // Row move
        int move_i = true_k / n;
        // Column move
        int move_j = true_k % n;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int new_i = i + move_i;
                int new_j = (j + move_j) % n;
                // Move 1 row if (move_j + j >= n
                if (move_j + j >= n) new_i ++;
                new_i %= m;
                newGrid[new_i][new_j] = grid[i][j];
            }
        }
        // Copy the grid into a list for returning.
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : newGrid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row) listRow.add(v);
        }
        return result;
    }
}
