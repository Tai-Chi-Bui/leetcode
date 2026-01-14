/*
 * Problem: 766. Toeplitz Matrix
 * 
 * Description:
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 * 
 * Requirements:
 * - Check if matrix is Toeplitz
 * - Toeplitz means all diagonals have same elements
 * - Return true if Toeplitz, false otherwise
 * 
 * Example:
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation: In the above grid, the diagonals are: "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * 
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 20
 * - 0 <= matrix[i][j] <= 99
 */

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Start from second line and column
        for (int r = 1; r < matrix.length; ++r)
            for (int c = 1; c < matrix[0].length; ++c)
                // Check step by step
                if (matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}
