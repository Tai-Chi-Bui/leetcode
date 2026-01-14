/*
 * Problem: 448. Find All Numbers Disappeared in an Array
 * 
 * Description:
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all
 * the integers in the range [1, n] that do not appear in nums.
 * 
 * Requirements:
 * - Find all numbers in range [1, n] that don't appear in array
 * - Return list of missing numbers
 * 
 * Example:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - 1 <= nums[i] <= n
 */

class Solution {
    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92956/Java-accepted-simple-solution
     public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
