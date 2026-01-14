/*
 * Problem: 1064. Fixed Point
 * 
 * Description:
 * Given an array of distinct integers arr, where arr is sorted in ascending order,
 * return the smallest index i that satisfies arr[i] == i. If there is no such index, return -1.
 * 
 * Requirements:
 * - Find the smallest index where arr[i] == i
 * - Array is sorted in ascending order
 * - Return -1 if no such index exists
 * 
 * Example:
 * Input: arr = [-10,-5,0,3,7]
 * Output: 3
 * Explanation: For the given array, arr[0] = -10, arr[1] = -5, arr[2] = 0, arr[3] = 3, thus the output is 3.
 * 
 * Constraints:
 * - 1 <= arr.length < 10^4
 * - -10^9 <= arr[i] <= 10^9
 */

class Solution {
    /* public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            // Because if A[i] > i, then i can never be greater than A[i] any more
            if (A[i] == i) return i;
            else if (A[i] > i) return -1;
        }
        return -1;
    } */
    public int fixedPoint(int[] A) {
        int l = 0;
        int h = A.length;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (A[mid] > mid) h = mid - 1;
            else if (A[mid] < mid) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}
