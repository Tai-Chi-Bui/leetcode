"""
Problem: 922. Sort Array By Parity II

Description:
Given an array of integers nums, half of the integers in nums are odd, and the other half are even. Sort the array so that
whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even. Return any answer array that satisfies this condition.

Requirements:
- Sort array so even indices have even numbers
- Odd indices have odd numbers
- Return sorted array

Example:
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Constraints:
- 2 <= nums.length <= 2 * 10^4
- nums.length % 2 == 0
- Half of the integers in nums are even, the other half are odd
- 0 <= nums[i] <= 1000
"""

class Solution(object):
    # def sortArrayByParityII(self, A):
    #     N = len(A)
    #     ans = [None] * N
    #     t = 0
    #     for i, x in enumerate(A):
    #         if x % 2 == 0:
    #             ans[t] = x
    #             t += 2
    #     t = 1
    #     for i, x in enumerate(A):
    #         if x % 2 == 1:
    #             ans[t] = x
    #             t += 2
    #     # We could have also used slice assignment:
    #     # ans[::2] = (x for x in A if x % 2 == 0)
    #     # ans[1::2] = (x for x in A if x % 2 == 1)
    #     return ans

    def sortArrayByParityII(self, A):
        odd = 1
        for i in xrange(0, len(A), 2):
            if A[i] % 2:
                while A[odd] % 2:
                    odd += 2
                A[i], A[odd] = A[odd], A[i]
        return A
