"""
Problem: 868. Binary Gap

Description:
Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n.
If there are no two adjacent 1's, return 0. Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.

Requirements:
- Find longest distance between adjacent 1's in binary representation
- Return 0 if no two adjacent 1's
- Return the maximum gap

Example:
Input: n = 22
Output: 2
Explanation: 22 in binary is "10110". The first adjacent pair of 1's is "10110" with a distance of 2. The second adjacent pair of 1's is "10110" with a distance of 1. The answer is the largest of these two distances, which is 2.

Constraints:
- 1 <= n <= 10^9
"""

class Solution:

    # def binaryGap(self, n: int) -> int:
    #     # Store index
    #     A = [i for i in xrange(32) if (N >> i) & 1]
    #     if len(A) < 2: return 0
    #     return max(A[i+1] - A[i] for i in xrange(len(A) - 1))


    def binaryGap(self, n: int) -> int:
        # one pass and store max
        current = 1
        last1 = -1
        out = 0
        while n > 0:
            if n % 2 == 1:
                if last1 >= 1:
                    out = max(out, current - last1)
                last1 = current
            current += 1
            n = n // 2
        return out
    
    # def binaryGap(self, n: int) -> int:
    #     # one pass and store max
    #     res = 0
    #     last = -1
    #     # Get binary encoding with bin
    #     for i, curr in enumerate(bin(n)[2:]):
    #         if curr == '1':
    #             if last >= 0:
    #                 res = max(res, i - last)
    #             last = i
    #     return res
