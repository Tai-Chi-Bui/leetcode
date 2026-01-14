/*
 * Problem: 668. Kth Smallest Number in Multiplication Table
 * 
 * Description:
 * Nearly everyone has used the Multiplication Table. The multiplication table of size m x n
 * is an integer matrix mat where mat[i][j] == i * j (1-indexed).
 * Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
 * 
 * Requirements:
 * - Create a multiplication table of size m x n where mat[i][j] = i * j
 * - Find the kth smallest element in this table
 * - Return the kth smallest value
 * 
 * Example:
 * Input: m = 3, n = 3, k = 5
 * Output: 3
 * Explanation: The 5th smallest number is 3.
 * Multiplication table:
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * Sorted: 1, 2, 2, 3, 3, 4, 6, 6, 9
 * 
 * Constraints:
 * - 1 <= m, n <= 3 * 10^4
 * - 1 <= k <= m * n
 */

class Solution {
public:
#define ll long long int
    bool valid(ll x, int m, int n, int k) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += n < x / i ? n : x / i;
            if (x / i == 0)
                break;
        }
        return cnt >= k;
    }

    int findKthNumber(int n1, int n2, int k) {
        ll l = 0, r = n1 * n2, ans;
        while (l <= r) {
            // ith row [i, 2*i, 3*i, ..., n*i]
            // for each column, k = x // i
            ll m = l + (r - l) / 2;
            if (valid(m, n1, n2, k)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
};
