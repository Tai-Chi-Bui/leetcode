/*
 * Problem: 665. Non-decreasing Array
 * 
 * Description:
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by
 * modifying at most one element. We define an array is non-decreasing if nums[i] <= nums[i + 1]
 * holds for every i (0-based) such that (0 <= i <= n - 2).
 * 
 * Requirements:
 * - Check if array can be made non-decreasing by modifying at most one element
 * - Non-decreasing means nums[i] <= nums[i+1] for all i
 * - Return true if possible, false otherwise
 * 
 * Example:
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^4
 * - -10^5 <= nums[i] <= 10^5
 */

class Solution {
    /* public boolean checkPossibility(int[] nums) {
        int pos = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                // More than two broken points
                if (pos != -1) return false;
                pos = i;
            }
        }
        if (pos == -1 || pos == 0 || pos == nums.length - 2) return true;
        // Remove pos or pos + 1
        return (nums[pos - 1] <= nums[pos + 1] || nums[pos] <= nums[pos + 2]);
    } */

    public boolean checkPossibility(int[] nums) {
        int brokenPoint = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                brokenPoint++;
                if (brokenPoint >= 2) return false;
                // Remove i or remove i + 1
                if (i - 1 < 0 || nums[i - 1] <= nums[i + 1]) nums[i] = nums[i + 1];
                else nums[i + 1] = nums[i];
            }
        }
        return true;
    }
}
