/*
 * Problem: 1089. Duplicate Zeros
 * 
 * Description:
 * Given a fixed-length integer array arr, duplicate each occurrence of zero,
 * shifting the remaining elements to the right. Note that elements beyond the
 * length of the original array are not written. Do the above modifications to
 * the input array in place and do not return anything.
 * 
 * Requirements:
 * - Duplicate each zero in the array
 * - Shift remaining elements to the right
 * - Modify array in-place
 * - Elements beyond original length are discarded
 * 
 * Example:
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * 
 * Constraints:
 * - 1 <= arr.length <= 10^4
 * - 0 <= arr[i] <= 9
 */

class Solution {
    public void duplicateZeros(int[] arr) {
        int movePos = 0;
        int lastPos = arr.length - 1;
        // Only check [0, lastPos - movePos]
        for (int i = 0; i <= lastPos - movePos; i++) {
            if (arr[i] == 0) {
                // Special case
                if (i == lastPos - movePos) {
                    arr[lastPos] = 0;
                    lastPos--;
                    break;
                }
                movePos++;
            }
        }
        lastPos = lastPos - movePos;
        for (int i = lastPos; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + movePos] = 0;
                movePos--;
                arr[i + movePos] = 0;
            } else {
                arr[i + movePos] = arr[i];
            }
        }
    }
}
