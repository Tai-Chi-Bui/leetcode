/*
 * Problem: 922. Sort Array By Parity II
 * 
 * Description:
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even. Sort the array so that
 * whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even. Return any answer array that satisfies this condition.
 * 
 * Requirements:
 * - Sort array so even indices have even numbers
 * - Odd indices have odd numbers
 * - Return sorted array
 * 
 * Example:
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * 
 * Constraints:
 * - 2 <= nums.length <= 2 * 10^4
 * - nums.length % 2 == 0
 * - Half of the integers in nums are even, the other half are odd
 * - 0 <= nums[i] <= 1000
 */

class Solution {
    /*public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        int t = 0;
        for (int x: A) if (x % 2 == 0) {
            ans[t] = x;
            t += 2;
        }
        t = 1;
        for (int x: A) if (x % 2 == 1) {
            ans[t] = x;
            t += 2;
        }
        return ans;
    }*/
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;
    }
}
