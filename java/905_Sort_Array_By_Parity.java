/*
 * Problem: 905. Sort Array By Parity
 * 
 * Description:
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 * 
 * Requirements:
 * - Move all even numbers to the beginning
 * - Move all odd numbers to the end
 * - Return modified array
 * 
 * Example:
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * Constraints:
 * - 1 <= nums.length <= 5000
 * - 0 <= nums[i] <= 5000
 */

class Solution {
/*    public int[] sortArrayByParity(int[] A) {
        A = Arrays.stream(A).
                boxed().
                sorted((a, b) -> Integer.compare(a% 2, b % 2)).
                mapToInt(i -> i).
                toArray();
        return A;
    }*/

    /*public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int pos = 0;
        for (int num: A) 
            if (num % 2 == 0)
                ans[pos++] = num;
        for (int num: A) 
            if (num % 2 == 1)
                ans[pos++] = num;
        return ans;
    }*/

    public int[] sortArrayByParity(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] % 2 > A[hi] % 2) {
                int tmp = A[hi];
                A[hi] = A[lo];
                A[lo] = tmp;
            }
            if (A[lo] % 2 == 0) lo++;
            if (A[hi] % 2 == 1) hi--;
        }
        return A;
    }
}
