/*
 * Problem: 509. Fibonacci Number
 * 
 * Description:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that
 * each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1
 * Given n, calculate F(n).
 * 
 * Requirements:
 * - Calculate nth Fibonacci number
 * - F(0) = 0, F(1) = 1
 * - F(n) = F(n-1) + F(n-2) for n > 1
 * 
 * Example:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1
 * 
 * Constraints:
 * - 0 <= n <= 30
 */

class Solution {
    /*public int fib(int N) {
        // Recursively, O(n)
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N - 1) + fib(N - 2);
    }*/

    private List<Integer> memo;

    public Solution() {
        memo = new ArrayList();
        memo.add(0);
        memo.add(1);
    }

    public int fib(int N) {
        // Dp with memo, O(n)
        if (N < memo.size()) return memo.get(N);
        for (int i = memo.size(); i <= N; i++) {
            memo.add(memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(N);
    }
}
