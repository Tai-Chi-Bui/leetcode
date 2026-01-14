/*
 * Problem: 268. Missing Number
 * 
 * Description:
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number
 * in the range that is missing from the array.
 * 
 * Requirements:
 * - Find the missing number in range [0, n]
 * - Array contains n distinct numbers
 * - Return the missing number
 * 
 * Example:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number.
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^4
 * - 0 <= nums[i] <= n
 * - All the numbers of nums are unique
 */

class Solution {
    /* public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
        }
        return total;
    } */

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    /* public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    } */
}
