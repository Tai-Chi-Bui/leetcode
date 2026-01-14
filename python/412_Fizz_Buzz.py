"""
Problem: 412. Fizz Buzz

Description:
Given an integer n, return a string array answer (1-indexed) where:
- answer[i] == "FizzBuzz" if i is divisible by 3 and 5
- answer[i] == "Fizz" if i is divisible by 3
- answer[i] == "Buzz" if i is divisible by 5
- answer[i] == i (as a string) if none of the above conditions are true

Requirements:
- Return array of strings from 1 to n
- Replace numbers divisible by 3 with "Fizz"
- Replace numbers divisible by 5 with "Buzz"
- Replace numbers divisible by both 3 and 5 with "FizzBuzz"
- Otherwise, return the number as a string

Example:
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

Constraints:
- 1 <= n <= 10^4
"""

class Solution(object):
    # def fizzBuzz(self, n):
    #     """
    #     :type n: int
    #     :rtype: List[str]
    #     """
    #     res = []
    #     for i in range(1, n + 1):
    #         if i % 3 == 0:
    #             if i % 5 == 0:
    #                 res.append('FizzBuzz')
    #             else:
    #                 res.append('Fizz')
    #         elif i % 5 == 0:
    #             res.append('Buzz')
    #         else:
    #             res.append(str(i))
    #     return res

    # def fizzBuzz(self, n):
    #     """
    #     :type n: int
    #     :rtype: List[str]
    #     """
    #     res = []
    #     for i in range(1, n + 1):
    #         curr = ''
    #         if i % 3 == 0:
    #             curr += 'Fizz'
    #         if i % 5 == 0:
    #             curr += 'Buzz'
    #         if not len(curr):
    #             curr += str(i)
    #         res.append(curr)
    #     return res

    def fizzBuzz(self, n):
        return [str(i) * (i % 3 != 0 and i % 5 != 0) + "Fizz" * (i % 3 == 0) + "Buzz" * (i % 5 == 0) 
                for i in range(1, n + 1)]
    
    # def fizzBuzz(self, n):
    #     return ['Fizz' * (not i % 3) + 'Buzz' * (not i % 5) or str(i) for i in range(1, n+1)]
