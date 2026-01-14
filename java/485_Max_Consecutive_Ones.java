/*
 * Problem: 485. Max Consecutive Ones
 * 
 * Description:
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * 
 * Requirements:
 * - Find maximum number of consecutive 1's
 * - Return the count
 * 
 * Example:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - nums[i] is either 0 or 1
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // Add 1 when encounter 1
                curr++;
                if (curr > ans) ans = curr;
            } else {
                // Set to 0 when encounter 0
                curr = 0;
            }
        }
        return ans;
    }
}
