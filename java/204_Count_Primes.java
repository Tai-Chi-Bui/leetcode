/*
 * Problem: 204. Count Primes
 * 
 * Description:
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * 
 * Requirements:
 * - Count all prime numbers less than n (not including n)
 * - Return the count
 * 
 * Example:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * Constraints:
 * - 0 <= n <= 5 * 10^6
 */

class Solution {
    // ttps://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithm_complexity
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (i * i >= n)
                break;
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i)
                isPrime[j] = false;
        }
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                count++;
        return count;
    }
}
