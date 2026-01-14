/*
 * Problem: 1. Two Sum
 * 
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * 
 * Requirements:
 * - Return indices of two numbers that sum to target
 * - You may assume that each input would have exactly one solution
 * - You may not use the same element twice
 * - You can return the answer in any order
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists
 */

public class Solution {
    // example in leetcode book
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
