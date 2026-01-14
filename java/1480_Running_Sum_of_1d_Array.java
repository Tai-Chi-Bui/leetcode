/*
 * Problem: 1480. Running Sum of 1d Array
 * 
 * Description:
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * 
 * Requirements:
 * - Calculate running sum where each element is sum of all previous elements including current
 * - Modify array in-place or return new array
 * 
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * 
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - -10^6 <= nums[i] <= 10^6
 */

class Solution {
    public int[] runningSum(int[] nums) {
        if (nums.length <= 1) return nums;
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        return nums;
    }
}
