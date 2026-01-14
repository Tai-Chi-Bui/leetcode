"""
Problem: 784. Letter Case Permutation

Description:
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. Return the answer in any order.

Requirements:
- Generate all possible strings by changing letter case
- Each letter can be lowercase or uppercase
- Non-letters remain unchanged
- Return list of all permutations

Example:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Constraints:
- 1 <= s.length <= 12
- s consists of lowercase English letters, uppercase English letters, and digits
"""

class Solution(object):
    # def letterCasePermutation(self, S):
    #     ans = [[]]

    #     for char in S:
    #         n = len(ans)
    #         if char.isalpha():
    #             # Double the ans
    #             for i in xrange(n):
    #                 ans.append(ans[i][:])
    #                 ans[i].append(char.lower())
    #                 ans[n + i].append(char.upper())
    #         else:
    #             # Normal append
    #             for i in xrange(n):
    #                 ans[i].append(char)

    #     return map("".join, ans)

    def letterCasePermutation(self, S):
        B = sum(letter.isalpha() for letter in S)
        ans = []

        for bits in xrange(1 << B):
            b = 0
            word = []
            for letter in S:
                if letter.isalpha():
                    if (bits >> b) & 1:
                        word.append(letter.lower())
                    else:
                        word.append(letter.upper())

                    b += 1
                else:
                    word.append(letter)

            ans.append("".join(word))
        return ans
