/*
 * Problem: 26. Remove Duplicates from Sorted Array
 * 
 * Description:
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should
 * be kept the same. Then return the number of unique elements in nums.
 * 
 * Requirements:
 * - Remove duplicates in-place (modify nums)
 * - Maintain relative order of elements
 * - Return the number of unique elements (k)
 * - First k elements of nums should contain the unique elements
 * 
 * Example:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2.
 * 
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -100 <= nums[i] <= 100
 * - nums is sorted in non-decreasing order
 */

//026. Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i + 1];
                index++;
            }
        }

        return index;
    }
}

