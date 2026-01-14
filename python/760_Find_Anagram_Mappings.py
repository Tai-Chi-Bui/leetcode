"""
Problem: 760. Find Anagram Mappings

Description:
You are given two integer arrays nums1 and nums2 where nums2 is an anagram of nums1. Both arrays may contain duplicates.
Return an index mapping array mapping from nums1 to nums2 where mapping[i] = j means the ith element in nums1 appears
as the jth element in nums2. If there are multiple answers, return any of them. An array a is an anagram of an array b
means b is a random rearrangement of a.

Requirements:
- Find index mapping from nums1 to nums2
- nums2 is anagram of nums1
- Return mapping array where mapping[i] = j means nums1[i] == nums2[j]

Example:
Input: nums1 = [12,28,46,32,50], nums2 = [50,12,32,46,28]
Output: [1,4,3,2,0]
Explanation: As mapping[0] = 1 because the 0th element of nums1 appears at nums2[1], and mapping[1] = 4 because the 1st element of nums1 appears at nums2[4], and so on.

Constraints:
- nums1.length == nums2.length
- n == nums1.length
- 1 <= n <= 100
- 0 <= nums1[i], nums2[i] <= 10^5
- nums2 is an anagram of nums1
"""

class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        val_index = {}
        ans = []
        for i, n in enumerate(B):
            val_index[n] = i
        for n in A:
            ans.append(val_index[n])
        return ans
