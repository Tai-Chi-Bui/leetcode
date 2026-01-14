/*
 * Problem: 442. Find All Duplicates in an Array
 * 
 * Description:
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 * and each integer appears once or twice, return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 * 
 * Requirements:
 * - Find all numbers that appear twice
 * - Time complexity: O(n)
 * - Space complexity: O(1) excluding output array
 * - Numbers are in range [1, n]
 * 
 * Example:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - 1 <= nums[i] <= n
 * - Each element in nums appears once or twice
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            int possibleVal = Math.abs(nums[i]);

            if(nums[possibleVal - 1] < 0) {
                ans.add(possibleVal);
            }
            nums[possibleVal - 1] = -1 * nums[possibleVal - 1];
        }
        return ans;
    }
}
