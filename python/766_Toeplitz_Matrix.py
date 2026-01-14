"""
Problem: 766. Toeplitz Matrix

Description:
Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

Requirements:
- Check if matrix is Toeplitz
- Toeplitz means all diagonals have same elements
- Return true if Toeplitz, false otherwise

Example:
Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation: In the above grid, the diagonals are: "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Constraints:
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 20
- 0 <= matrix[i][j] <= 99
"""

class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        # Actually, we don't need to check the last row and column
        for r in range(len(matrix) - 1):
            for c in range(len(matrix[0]) - 1):
                if matrix[r][c] != matrix[r + 1][c + 1]:
                    return False
        return True
