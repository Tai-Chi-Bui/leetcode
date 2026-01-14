"""
Problem: 204. Count Primes

Description:
Given an integer n, return the number of prime numbers that are strictly less than n.

Requirements:
- Count all prime numbers less than n (not including n)
- Return the count

Example:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Constraints:
- 0 <= n <= 5 * 10^6
"""

class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        # https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_complexity
        isPrime = [True] * n
        for i in xrange(2, n):
            if i * i >= n:
                break
            if not isPrime[i]:
                continue
            for j in xrange(i * i, n, i):
                isPrime[j] = False
        count = 0
        for i in xrange(2, n):
            if isPrime[i]:
                count += 1
        return count
