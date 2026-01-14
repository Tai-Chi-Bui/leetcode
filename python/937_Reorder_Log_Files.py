"""
Problem: 937. Reorder Log Files

Description:
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
There are two types of logs:
- Letter-logs: All words (except the identifier) consist of lowercase English letters
- Digit-logs: All words (except the identifier) consist of digits
Reorder these logs so that:
1. The letter-logs come before all digit-logs
2. The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers
3. The digit-logs maintain their relative ordering
Return the final order of the logs.

Requirements:
- Sort letter-logs before digit-logs
- Sort letter-logs by content, then by identifier
- Keep digit-logs in original order
- Return sorted array

Example:
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation: The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

Constraints:
- 1 <= logs.length <= 100
- 3 <= logs[i].length <= 100
- All tokens of logs[i] are separated by a single space
- logs[i] is guaranteed to have an identifier and at least one word after the identifier
"""

class Solution(object):
    # def reorderLogFiles(self, logs):
    #     """
    #     :type logs: List[str]
    #     :rtype: List[str]
    #     """
    #     def f(log):
    #         id_, rest = log.split(" ", 1)
    #         return (0, rest, id_) if rest[0].isalpha() else (1,)
        
    #     # Python sort is stable, so digit with keep their order
    #     return sorted(logs, key = f)

    def reorderLogFiles(self, logs):
        letter_logs = []
        digit_logs = []
        for log in logs:
            if log.split(' ')[1].isnumeric():
                digit_logs.append(log)
            else:
                letter_logs.append(log)
        return sorted(letter_logs, key=lambda x: x.split(' ')[1:] + x.split(' ')[0]) + digit_logs
        