/*
 * Problem: 977. Squares of a Sorted Array
 * 
 * Description:
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * 
 * Requirements:
 * - Square each number
 * - Sort squares in non-decreasing order
 * - Return sorted array
 * 
 * Example:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100].
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -10^4 <= nums[i] <= 10^4
 * - nums is sorted in non-decreasing order
 */

class Solution {
    /* public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i)
            res[i] = A[i] * A[i];

        Arrays.sort(res);
        return res;
    } */
    public int[] sortedSquares(int[] A) {
        int pos = 0;
        int[] res = new int[A.length];
        int curr = 0;
        while (pos < A.length && A[pos] < 0) pos++;
        int npos = pos - 1;
        while (pos < A.length && npos >= 0) {
            if (A[pos] * A[pos] < A[npos] * A[npos]) {
                res[curr++] = A[pos] * A[pos];
                pos++;
            } else {
                res[curr++] = A[npos] * A[npos];
                npos--;
            }
        }
        while (npos >= 0) {
            res[curr++] = A[npos] * A[npos];
            npos--;
        }
        while (pos < A.length) {
            res[curr++] = A[pos] * A[pos];
            pos++;
        }
        return res;
    }
}
