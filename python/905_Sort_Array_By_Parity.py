"""
Problem: 905. Sort Array By Parity

Description:
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Requirements:
- Move all even numbers to the beginning
- Move all odd numbers to the end
- Return modified array

Example:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Constraints:
- 1 <= nums.length <= 5000
- 0 <= nums[i] <= 5000
"""

class Solution(object):
    # def sortArrayByParity(self, A):
    #     """
    #     :type A: List[int]
    #     :rtype: List[int]
    #     """
    #     # Bad idea, O(nlogn)
    #     A.sort(key=lambda x: x % 2)
    #     return A

    # def sortArrayByParity(self, A):
    #     return ([x for x in A if x % 2 == 0] +
    #             [x for x in A if x % 2 == 1])

    def sortArrayByParity(self, A):
        # Quit like quick sort or quick selection
        lo, hi = 0, len(A) - 1
        while lo < hi:
            if A[lo] % 2 > A[hi] % 2:
                A[lo], A[hi] = A[hi], A[lo]
            if A[lo] % 2 == 0: lo += 1
            if A[hi] % 2 == 1: hi -= 1
        return A
