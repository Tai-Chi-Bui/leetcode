/*
 * Problem: 852. Peak Index in a Mountain Array
 * 
 * Description:
 * An array arr a mountain if the following properties hold:
 * - arr.length >= 3
 * - There exists some i with 0 < i < arr.length - 1 such that:
 *   - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *   - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * You must solve it in O(log(arr.length)) time complexity.
 * 
 * Requirements:
 * - Find peak index in mountain array
 * - Array increases then decreases
 * - Solve in O(log n) time
 * - Return the peak index
 * 
 * Example:
 * Input: arr = [0,1,0]
 * Output: 1
 * 
 * Constraints:
 * - 3 <= arr.length <= 10^5
 * - 0 <= arr[i] <= 10^6
 * - arr is guaranteed to be a mountain array
 */

class Solution {
    // public int peakIndexInMountainArray(int[] A) {
    //     int i = 0;
    //     for (; A[i] < A[i + 1]; i++);
    //     return i;
    // }

    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] < A[mid + 1]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
