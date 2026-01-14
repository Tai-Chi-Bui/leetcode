"""
Problem: 771. Jewels and Stones

Description:
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Requirements:
- Count how many stones are jewels
- Letters are case sensitive
- Return the count

Example:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Constraints:
- 1 <= jewels.length, stones.length <= 50
- jewels and stones consist of only English letters
- All the characters of jewels are unique
"""

class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        if len(J) == 0 or len(S) == 0:
            return 0
        j_set = set(J)
        ans = 0
        for c in S:
            if c in j_set:
                ans += 1
        return ans
