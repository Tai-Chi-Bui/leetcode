/*
 * Problem: 238. Product of Array Except Self
 * 
 * Description:
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i]. The product of any prefix or suffix of nums is
 * guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and
 * without using the division operator.
 * 
 * Requirements:
 * - Return array where each element is product of all other elements
 * - Time complexity must be O(n)
 * - Cannot use division operator
 * - Space complexity should be O(1) excluding output array
 * 
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - -30 <= nums[i] <= 30
 * - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer
 */

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            // left part
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            // right part
            right *= nums[i];
        }
        return res;
    }
}
