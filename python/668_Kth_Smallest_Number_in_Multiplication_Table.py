"""
Problem: 668. Kth Smallest Number in Multiplication Table

Description:
Nearly everyone has used the Multiplication Table. The multiplication table of size m x n
is an integer matrix mat where mat[i][j] == i * j (1-indexed).
Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

Requirements:
- Create a multiplication table of size m x n where mat[i][j] = i * j
- Find the kth smallest element in this table
- Return the kth smallest value

Example:
Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.
Multiplication table:
1 2 3
2 4 6
3 6 9
Sorted: 1, 2, 2, 3, 3, 4, 6, 6, 9

Constraints:
- 1 <= m, n <= 3 * 10^4
- 1 <= k <= m * n
"""

class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        # https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/solution/
        def enough(x):
            count = 0
            # ith row [i, 2*i, 3*i, ..., n*i]
            # for each column, k = x // i
            for i in range(1, m+1):
                count += min(x // i, n)
            return count >= k

        lo, hi = 1, m * n
        while lo < hi:
            mi = (lo + hi) // 2
            if not enough(mi):
                lo = mi + 1
            else:
                hi = mi
        return lo
