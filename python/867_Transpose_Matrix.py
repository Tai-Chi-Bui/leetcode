"""
Problem: 867. Transpose Matrix

Description:
Given a 2D integer array matrix, return the transpose of matrix. The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.

Requirements:
- Transpose the matrix
- Swap rows and columns
- Return transposed matrix

Example:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Constraints:
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 1000
- 1 <= m * n <= 10^5
- -10^9 <= matrix[i][j] <= 10^9
"""

class Solution(object):
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        R, C = len(A), len(A[0])
        ans = [[None] * R for _ in xrange(C)]
        for r, row in enumerate(A):
            for c, val in enumerate(row):
                ans[c][r] = val
        return ans
        # Alternative Solution:
        # return zip(*A)

    # def transpose(self, A):
    #     res = []
    #     for i in range(len(A[0])):
    #         temp = []
    #         for j in range(len(A)):
    #             temp.append(A[j][i])
    #         res.append(temp)
    #     return res
