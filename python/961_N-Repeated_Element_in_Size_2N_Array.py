"""
Problem: 961. N-Repeated Element in Size 2N Array

Description:
You are given an integer array nums with the following properties:
- nums.length == 2 * n
- nums contains n + 1 unique elements
- Exactly one element of nums is repeated n times
Return the element that is repeated n times.

Requirements:
- Find element repeated n times
- Array has 2n elements with n+1 unique elements
- Return the repeated element

Example:
Input: nums = [1,2,3,3]
Output: 3

Constraints:
- 2 <= n <= 5000
- nums.length == 2 * n
- 0 <= nums[i] <= 10^4
- nums contains n + 1 unique elements and one of them is repeated exactly n times
"""

import collections


class Solution(object):
    def repeatedNTimes(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        counter = collections.Counter(A)
        return counter.most_common(1)[0][0]


if __name__ == '__main__':
    s = Solution()
    print s.repeatedNTimes([1, 2, 3, 3])
    print s.repeatedNTimes([2, 1, 2, 5, 3, 2])
    print s.repeatedNTimes([5, 1, 5, 2, 5, 3, 5, 4])
