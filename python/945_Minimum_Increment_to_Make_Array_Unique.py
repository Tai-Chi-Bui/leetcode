"""
Problem: 945. Minimum Increment to Make Array Unique

Description:
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
Return the minimum number of moves to make every value in nums unique. The test cases are generated so that the answer will fit in a 32-bit integer.

Requirements:
- Make all values unique by incrementing
- Find minimum number of increments
- Return minimum moves

Example:
Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

Constraints:
- 1 <= nums.length <= 10^5
- 0 <= nums[i] <= 10^5
"""

class Solution(object):
    def minIncrementForUnique(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        if A is None or len(A) == 0:
            return 0
        res = 0
        num_set = set()
        duplicate = []
        A.sort()
        left, right = A[0], A[-1]
        holes = right - left + 1
        for v in A:
            if v in num_set:
                duplicate.append(v)
            else:
                num_set.add(v)
        holes = holes - len(num_set)
        # find a hole for these numbers
        for hole in range(left + 1, right):
            if holes == 0 or len(duplicate) == 0:
                break
            if hole not in num_set and hole > duplicate[0]:
                res += hole - duplicate.pop(0)
                holes -= 1
        while len(duplicate) != 0:
            right += 1
            res += right - duplicate.pop(0)
        return res


if __name__ == '__main__':
    s = Solution()
    # print s.minIncrementForUnique([3, 2, 1, 2, 1, 7])
    # print s.minIncrementForUnique([0, 2, 2])
