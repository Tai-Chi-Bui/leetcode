"""
Problem: 953. Verifying an Alien Dictionary

Description:
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters. Given a sequence of words written in the alien language,
and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

Requirements:
- Check if words are sorted in alien dictionary order
- Order is given as permutation of lowercase letters
- Return true if sorted, false otherwise

Example:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Constraints:
- 1 <= words.length <= 100
- 1 <= words[i].length <= 20
- order.length == 26
- All characters in words[i] and order are English lowercase letters
"""

class Solution(object):
    def isAlienSorted(self, words, order):
        """
        :type words: List[str]
        :type order: str
        :rtype: bool
        """
        order_map = {}
        for i, v in enumerate(order):
            order_map[v] = i

        def cmp_alien(x, y):
            ls = min(len(x), len(y))
            index = 0
            while index < ls:
                if x[index] != y[index]:
                    return order_map[x[index]] - order_map[y[index]]
                index += 1
            return len(x) - len(y)
        pos = 0
        while pos + 1 < len(words):
            if cmp_alien(words[pos], words[pos + 1]) > 0:
                return False
            pos += 1
        return True


if __name__ == '__main__':
    s = Solution()
    print s.isAlienSorted(["hello","leetcode"], "hlabcdefgijkmnopqrstuvwxyz")
    print s.isAlienSorted(["word","world","row"], "worldabcefghijkmnpqstuvxyz")
    print s.isAlienSorted(["apple","app"], "abcdefghijklmnopqrstuvwxyz")
