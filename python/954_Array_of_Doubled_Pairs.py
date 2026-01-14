"""
Problem: 954. Array of Doubled Pairs

Description:
Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i]
for every 0 <= i < len(arr) / 2, or false otherwise.

Requirements:
- Check if array can be reordered so arr[2*i+1] = 2*arr[2*i]
- Return true if possible, false otherwise

Example:
Input: arr = [3,1,3,6]
Output: false

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

Constraints:
- 2 <= arr.length <= 3 * 10^4
- arr.length is even
- -10^5 <= arr[i] <= 10^5
"""

class Solution(object):
    def canReorderDoubled(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        v_map = {}
        A.sort(key=lambda x: abs(x))
        for n in A:
            v_map[n] = v_map.get(n, 0) + 1
        for n in A:
            if v_map[n] <= 0:
                continue
            if 2 * n in v_map and v_map[2 * n] > 0:
                v_map[n] -= 1
                v_map[2 * n] -= 1
            else:
                return False
        return True


if __name__ == '__main__':
    s = Solution()
    print s.canReorderDoubled([3, 1, 3, 6])
    print s.canReorderDoubled([2, 1, 2, 6])
    print s.canReorderDoubled([4, -2, 2, -4])
    print s.canReorderDoubled([1, 2, 4, 16, 8, 4])
