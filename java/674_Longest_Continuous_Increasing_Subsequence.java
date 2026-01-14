/*
 * Problem: 674. Longest Continuous Increasing Subsequence
 * 
 * Description:
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing
 * subsequence (i.e. subarray). The subsequence must be strictly increasing. A continuous increasing
 * subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]
 * and for each l <= i < r, nums[i] < nums[i + 1].
 * 
 * Requirements:
 * - Find longest continuous increasing subsequence
 * - Subsequence must be strictly increasing
 * - Return the length
 * 
 * Example:
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element 4.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int curr = 1, ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                curr ++;
                if (curr >= ans) ans = curr;
            } else {
                curr = 1;
            }
        }
        return ans;
    }
}
