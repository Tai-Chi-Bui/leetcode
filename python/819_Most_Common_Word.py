"""
Problem: 819. Most Common Word

Description:
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
It is guaranteed there is at least one word that is not banned, and that the answer is unique. The words in paragraph are
case-insensitive and the answer should be returned in lowercase.

Requirements:
- Find most frequent word not in banned list
- Words are case-insensitive
- Return word in lowercase
- Ignore punctuation

Example:
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: "hit" occurs 3 times, but it is a banned word. "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.

Constraints:
- 1 <= paragraph.length <= 1000
- paragraph consists of English letters, space ' ', or one of the symbols: "!?',;."
- 0 <= banned.length <= 100
- 1 <= banned[i].length <= 10
- banned[i] consists of lowercase English letters
"""

class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        # https://leetcode.com/problems/most-common-word/discuss/193268/python-one-liner
        banned = set(banned)
        count = collections.Counter(word for word in re.split('[ !?\',;.]',
                                    paragraph.lower()) if word)
        return max((item for item in count.items() if item[0] not in banned),
                   key=operator.itemgetter(1))[0]
