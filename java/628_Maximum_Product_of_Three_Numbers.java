/*
 * Problem: 628. Maximum Product of Three Numbers
 * 
 * Description:
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 * 
 * Requirements:
 * - Find three numbers with maximum product
 * - Return the maximum product
 * 
 * Example:
 * Input: nums = [1,2,3]
 * Output: 6
 * 
 * Input: nums = [1,2,3,4]
 * Output: 24
 * 
 * Constraints:
 * - 3 <= nums.length <= 10^4
 * - -1000 <= nums[i] <= 1000
 */

public class Solution {
    /*public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }*/
    
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}

